package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Room;

public class StartCommand implements Command{
    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        return null;
    }
}
