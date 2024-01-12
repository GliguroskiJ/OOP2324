package cz.cvut.oop.game;

import cz.cvut.oop.model.Enemy;

import java.util.Collection;

public interface Room {

    String getName();
    String getDescription();
    String getDescriptionWithExits();
    Collection<Room> getExits();
    Room getExitByName(String name);
    void registerExit(Room room);
}
