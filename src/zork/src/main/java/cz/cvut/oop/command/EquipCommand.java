package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.model.*;

import java.util.HashMap;
import java.util.Map;

public class EquipCommand implements Command{

    @Override
    public String getName() {
        return "equip";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if (arguments.length < 2) return "Špatně zadaný příkaz. Pro více info použij příkaz [help]";

        String weaponToEquip = arguments[1];
        Item weapon;
        Item newWeapon;
        Player player = gameData.getPlayer();
        Enemy enemy = gameData.getCurrentRoom().getEnemy();
        Map<String, Item> inventoryMap = new HashMap<>();

        if (player.getInventory().openInventory().isEmpty()) return "Máš prázdný inventář";
        else {
            for (int i = 0; i < player.getInventory().openInventory().size(); i++){
                inventoryMap.put(player.getInventory().openInventory().get(i).getName(), player.getInventory().openInventory().get(i));
            }
        }

        if (inventoryMap.containsKey(weaponToEquip) && (inventoryMap.get(weaponToEquip).getType() == Item.itemType.weapon) && gameData.getCurrentRoom().isEnemyNull()) {
            weapon = inventoryMap.get(weaponToEquip);
            player.getInventory().openInventory().remove(inventoryMap.get(weaponToEquip));
            inventoryMap.remove(weaponToEquip);
            newWeapon = player.swapWeapons(weapon);
            return "Do ruky sis dal předmět " + newWeapon.getName() + " se sílou útoku od " + newWeapon.getDamage()[0] + " do " + newWeapon.getDamage()[1] + "\n" +
                    player.getInventory().listItemsInInventory();

        } else if (inventoryMap.containsKey(weaponToEquip) && (inventoryMap.get(weaponToEquip).getType() == Item.itemType.weapon) && enemy.isDead()) {
            weapon = inventoryMap.get(weaponToEquip);
            player.getInventory().openInventory().remove(inventoryMap.get(weaponToEquip));
            inventoryMap.remove(weaponToEquip);
            newWeapon = player.swapWeapons(weapon);
            return "Do ruky sis dal předmět " + newWeapon.getName() + " se sílou útoku od " + newWeapon.getDamage()[0] + " do " + newWeapon.getDamage()[1] + "\n" +
                    player.getInventory().listItemsInInventory();

        } else if ((inventoryMap.containsKey(weaponToEquip)) && (inventoryMap.get(weaponToEquip).getType() == Item.itemType.weapon) && ((!enemy.isDead()) || !gameData.getCurrentRoom().isEnemyNull())) {
            int healthAfterAttack;
            int enemyDamage = enemy.getDamage();
            player.setHealth(player.getHealth()-enemyDamage);
            healthAfterAttack = player.getHealth();

            weapon = inventoryMap.get(weaponToEquip);
            player.getInventory().openInventory().remove(inventoryMap.get(weaponToEquip));
            inventoryMap.remove(weaponToEquip);
            newWeapon = player.swapWeapons(weapon);
            return "Do ruky sis dal předmět " + newWeapon.getName() + " se sílou útoku od " + newWeapon.getDamage()[0] + " do " + newWeapon.getDamage()[1] + "\n" +
                    "Obdržel si " + enemyDamage + " bodů poškození a aktuálně máš " + healthAfterAttack + " životů" + "\n" +
                    player.getInventory().listItemsInInventory();

        } else if (inventoryMap.containsKey(weaponToEquip) && inventoryMap.get(weaponToEquip).getType() == Item.itemType.key) {
            return "Tento předmět si nemůžeš nasadit";

        } else return "Takový předmět v inventáři nemáš";
    }
}
