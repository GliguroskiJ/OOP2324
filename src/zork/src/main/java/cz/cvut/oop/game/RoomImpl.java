package cz.cvut.oop.game;

import cz.cvut.oop.model.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Class represents Room, e.g. space in our game. It contains exits and can form a map of Rooms
 */
public class RoomImpl implements Room {

    private String name;
    private String description;
    private Map<String,Room> exits = new HashMap<>();
    private Enemy enemy;
    private ArrayList<Item> floor;

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
     *  Return unmodifiable view of our map
     */
    @Override
    public Collection<Room> getExits() {
        return Collections.unmodifiableCollection(exits.values());
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
        if (enemy == null){
            return null;
        }
        else return enemy;
    }

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
}
