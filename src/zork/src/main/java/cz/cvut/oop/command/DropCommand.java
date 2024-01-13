package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.model.Item;
import cz.cvut.oop.model.Player;

import java.util.HashMap;
import java.util.Map;

public class DropCommand implements Command{
    @Override
    public String getName() {
        return "drop";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if (arguments.length < 2) return "Špatně zadaný příkaz. Pro více info použij příkaz [help]";

        Player player = gameData.getPlayer();
        Room room = gameData.getCurrentRoom();
        String itemToDrop = arguments[1];
        Map<String, Item> inventoryMap = new HashMap<>();

        if (player.getInventory().openInventory().isEmpty()) return "Máš prázdný inventář";
        else {
            for (int i = 0; i < player.getInventory().openInventory().size(); i++){
                inventoryMap.put(player.getInventory().openInventory().get(i).getName(), player.getInventory().openInventory().get(i));
            }
        }

        if (inventoryMap.containsKey(itemToDrop)) {
            player.getInventory().openInventory().remove(inventoryMap.get(itemToDrop));
            room.getFloor().add(inventoryMap.get(itemToDrop));

            return "Na zem si položil předmět " + itemToDrop;
        } else return "Takový předmět v inventáři nemáš";
    }
}
