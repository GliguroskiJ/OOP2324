package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;

public class EndCommand implements Command{
    @Override
    public String getName() {
        return "end";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        gameData.setFinished(true);
        gameData.isFinished();
        return "Hra byla ukončena";
    }
}
