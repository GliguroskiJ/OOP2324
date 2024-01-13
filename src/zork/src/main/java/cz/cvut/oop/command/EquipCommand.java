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
        String weaponToEquip = arguments[1];
        Item weapon;
        Item newWeapon;
        Player player = gameData.getPlayer();
        Map<String, Item> inventoryMap = new HashMap<>();

        if (player.getInventory().getInventory().isEmpty()) return "Máš prázdný inventář";
        else {
            for (int i = 0; i < player.getInventory().getInventory().size(); i++){
                inventoryMap.put(player.getInventory().getInventory().get(i).getName(), player.getInventory().getInventory().get(i));
            }
        }

        if (inventoryMap.containsKey(weaponToEquip) && inventoryMap.get(weaponToEquip).getType() == Item.itemType.weapon) {
            weapon = inventoryMap.get(weaponToEquip);
            player.getInventory().getInventory().remove(inventoryMap.get(weaponToEquip));
            inventoryMap.remove(weaponToEquip);
            newWeapon = player.swapWeapons(weapon);
            return "Do ruky sis dal předmět " + newWeapon.getName() + " se sílou útoku od " + newWeapon.getDamage()[0] + " do " + newWeapon.getDamage()[1] + "\n" +
                    player.getInventory().listItemsInInventory();

        } else if (inventoryMap.containsKey(weaponToEquip) && inventoryMap.get(weaponToEquip).getType() == Item.itemType.key) {
            return "Tento předmět si nemůžeš nasadit";
        }
        else return "Takový předmět v inventáři nemáš";
    }
}
