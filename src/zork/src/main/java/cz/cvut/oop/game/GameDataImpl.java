package cz.cvut.oop.game;

import cz.cvut.oop.model.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 *  All mutable game data should exist within this class
 *  e.g. room map, finished, inventory, weapons..
 */
public class GameDataImpl implements GameData {

    private Room currentRoom;
    private boolean finished;
    private List<Room> rooms;

    /**
     *  Room map registration in constructor
     */
    public GameDataImpl(){
        this.init();
    }

    public void init(){
        this.rooms = new ArrayList<>();

        Room corridor = new RoomImpl("chodba", "Všude boty a jeden východ");
        Room library = new RoomImpl("knihovna", "Spousta knížek na jendom místě", new Enemy("Babka knihařka", new int[]{1,2}, 15));
        Room bedroom = new RoomImpl("loznice", "Neustlaná postel a ospalá entita", new Enemy("Ospalý syn majitele", new int[]{4,7}, 30));
        Room kitchen = new RoomImpl("kuchyn", "Neskutčný bordel v kuchyni", new Enemy("Magická létající kuchařka", new int[]{8,11}, 40));
        Room livingRoom = new RoomImpl("obyvacipokoj","Oslepující zlatý lustr ti svítí do očí", new Enemy("Securiťák", new int[]{10,12}, 50));
        Room larder = new RoomImpl("spizirna", "Takového jídla...", new Enemy("Myš", new int[]{1,2}, 10));
        Room workRoom = new RoomImpl("pracoviste", "Ten majitel je fakt tlustej", new Enemy("Majitel", new int[]{15,20}, 70));

        corridor.registerExit(library);
        library.registerExit(bedroom);
        bedroom.registerExit(kitchen);
        kitchen.registerExit(livingRoom);
        livingRoom.registerExit(larder);
        livingRoom.registerExit(workRoom);
        larder.registerExit(livingRoom);

        rooms.add(corridor);
        rooms.add(library);
        rooms.add(bedroom);
        rooms.add(kitchen);
        rooms.add(livingRoom);
        rooms.add(larder);
        rooms.add(workRoom);

        this.currentRoom = corridor;
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     *  Sets room, where the user currently resides
     */
    @Override
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     *  Sets finished flag, indicating game is done/finished
     */
    @Override
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     *  Retrieves finished flag -> parent components decides whether to end the game
     *  based on this method
     */
    @Override
    public boolean isFinished() {
        return finished;
    }
}
