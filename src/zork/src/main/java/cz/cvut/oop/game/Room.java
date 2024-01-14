package cz.cvut.oop.game;

import cz.cvut.oop.model.Enemy;
import cz.cvut.oop.model.Item;

import java.util.ArrayList;
import java.util.Collection;

public interface Room {

    String getName();
    String getDescription();
    String getDescriptionWithExits();
    Room getExitByName(String name);
    void registerExit(Room room);
    Enemy getEnemy();
    ArrayList<Item> getFloor();
    String lookOnFloor();
    boolean isEnemyNull();
    boolean isWasVisited();
    void setWasVisited(boolean wasVisited);
}
