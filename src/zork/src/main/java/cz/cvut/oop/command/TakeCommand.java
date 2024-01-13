package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;

public class TakeCommand implements Command{
    @Override
    public String getName() {
        return "take";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String selectedItem = arguments[1];

        if (gameData.getCurrentRoom().getFloor().get(0).getName().equals("klic")) {
            gameData.getPlayer().getInventory().addToInventory(gameData.getCurrentRoom().getFloor().get(0));
            gameData.getCurrentRoom().getFloor().remove(0);
            return "Sebral si " + selectedItem;
        }
        else return "Takový předmět na zemi není";
    }
}
