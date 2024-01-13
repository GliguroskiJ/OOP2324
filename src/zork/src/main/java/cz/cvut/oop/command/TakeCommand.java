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
            player.getInventory().addToInventory(itemMap.get(selectedItem));
            gameData.getCurrentRoom().getFloor().remove(itemMap.get(selectedItem));
            itemMap.remove(selectedItem);
            return "Předmět " + selectedItem + " byl přidán do inventáře\n"+
                    player.getInventory().listItemsInInventory();
        }
        else return "Takový předmět na zemi není";
    }
}
