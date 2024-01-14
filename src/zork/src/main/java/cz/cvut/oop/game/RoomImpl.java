package cz.cvut.oop.game;

import cz.cvut.oop.model.*;

import java.util.*;

/**
 *  Class represents Room, e.g. space in our game. It contains exits and can form a map of Rooms
 */
public class RoomImpl implements Room {

    private final String name;
    private final String description;
    private final Map<String,Room> exits = new HashMap<>();
    private final Enemy enemy;
    private final ArrayList<Item> floor;
    private boolean wasVisited;

    public RoomImpl(String name, String description, Enemy enemy){
        this.name = name;
        this.description = description;
        this.enemy = enemy;
        this.floor = new ArrayList<>();
    }
    public RoomImpl(String name, String description){
        this.name = name;
        this.description = description;
        this.enemy = null;
        this.floor = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (enemy == null){
            return "Popisek místnosti: " + description + "\n" +
                    getDescriptionWithExits();
        }
        else return "Popisek místnosti: " + description + "\n" +
                "V místnosti se nachází " + enemy.getName() + " s " + enemy.getHealth() + " životy\n" +
                getDescriptionWithExits();
    }
    /**
     *  Adds new exit to map
     */
    @Override
    public void registerExit(Room room){
        exits.put(room.getName(), room);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     *  Method returns description of this room (from getDescription call)
     *  and should add possible exit names
     */
    @Override
    public String getDescriptionWithExits() {
        return String.join(", ", this.exits.keySet());
    }

    /**
     *  Method returns description of this room
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     *  Returns room based on entered room (exit) name
     */
    @Override
    public Room getExitByName(String name) {
        return exits.getOrDefault(name, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomImpl room = (RoomImpl) o;
        return Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public boolean isEnemyNull() {
        if (enemy == null){
            return true;
        }
        else return false;
    }

    @Override
    public ArrayList<Item> getFloor() {
        return floor;
    }

    @Override
    public String lookOnFloor() {
        if (getFloor().isEmpty()){
            return "Na zemi nejsou žádné předměty";
        }
        else {
            ArrayList<String> itemNames = new ArrayList<>();
            for (int i = 0; i < getFloor().size(); i++){
                itemNames.add(getFloor().get(i).getName());
            }
            return String.join(", ", itemNames);
        }
    }

    @Override
    public boolean isWasVisited() {
        return wasVisited;
    }

    @Override
    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
