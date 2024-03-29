package cz.cvut.oop.game;

import cz.cvut.oop.model.Player;

import java.util.List;

public interface GameData {

    boolean isFinished();
    void setFinished(boolean finished);
    Room getCurrentRoom();
    void setCurrentRoom(Room currentRoom);
    void init();
    Player getPlayer();
    boolean exitRoom(Room currentRoom);
}
