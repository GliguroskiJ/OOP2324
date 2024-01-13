package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TakeCommand implements Command{
    @Override
    public String getName() {
        return "take";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String selectedItem = arguments[1];
        Player player = gameData.getPlayer();
        Map<String, Item> itemMap = new HashMap<>();

        for (int i = 0; i < gameData.getCurrentRoom().getFloor().size(); i++){
            itemMap.put(gameData.getCurrentRoom().getFloor().get(i).getName(), gameData.getCurrentRoom().getFloor().get(i));
        }

        if (itemMap.containsKey(selectedItem)){
            player.getInventory().getInventory().add(itemMap.get(selectedItem));
            itemMap.remove(selectedItem);
            gameData.getCurrentRoom().getFloor().remove(itemMap.get(selectedItem));
            return "Předmět " + selectedItem + " byl přidán do inventáře\n"+
                    "V inventáří máš aktuálně " + player.getInventory().listItemsInInventory();
        }
        else return "Takový předmět na zemi není";
    }
}
