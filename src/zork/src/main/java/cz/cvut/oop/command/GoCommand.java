package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Room;

public class GoCommand implements Command{
    @Override
    public String getName() {
        return "jdi";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {

        String roomName = arguments[1];

        Room exitByName = gameData.getCurrentRoom().getExitByName(roomName);
        if(exitByName == null){
            return "neexistujici exit";
        }
        gameData.setCurrentRoom(exitByName);
        return "Přesunut do místnosti " + gameData.getCurrentRoom().getDescriptionWithExits();
    }
}
