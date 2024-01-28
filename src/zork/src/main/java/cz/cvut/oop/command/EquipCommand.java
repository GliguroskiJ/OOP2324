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
            return player.weaponChange(inventoryMap, weaponToEquip);

        } else if (inventoryMap.containsKey(weaponToEquip) && (inventoryMap.get(weaponToEquip).getType() == Item.itemType.weapon) && enemy.isDead()) {
            return  player.weaponChange(inventoryMap, weaponToEquip);

        } else if ((inventoryMap.containsKey(weaponToEquip)) && (inventoryMap.get(weaponToEquip).getType() == Item.itemType.weapon) && ((!enemy.isDead()) || !gameData.getCurrentRoom().isEnemyNull())) {
            return player.weaponChange(inventoryMap, weaponToEquip) + "\n" +
                    enemy.onlyEnemyDealDamage(gameData, null);

        } else if (inventoryMap.containsKey(weaponToEquip) && inventoryMap.get(weaponToEquip).getType() == Item.itemType.key) {
            return "Tento předmět si nemůžeš nasadit";

        } else return "Takový předmět v inventáři nemáš";
    }
}
