package cz.cvut.oop.game;

import cz.cvut.oop.model.*;

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
    private Player player;
    /**
     *  Room map registration in constructor
     */
    public GameDataImpl(){
        this.init();
    }

    public void init(){
        this.rooms = new ArrayList<>();

        Room corridor = new RoomImpl("chodba", "Všude boty a jeden východ");
        Room library = new RoomImpl("knihovna", "Spousta knížek na jednom místě", new Enemy("Babka knihařka", new int[]{1,2}, 15, Enemy.enemyType.normal, new Item(new int[]{8, 10}, "kniha")));
        Room bedroom = new RoomImpl("loznice", "Neustlaná postel a ospalá entita", new Enemy("Ospalý syn majitele", new int[]{4,6}, 30, Enemy.enemyType.normal, new Item(new int[]{12, 14}, "telefon")));
        Room kitchen = new RoomImpl("kuchyn", "Neskutčný bordel v kuchyni", new Enemy("Rozhořčená majitelova manželka", new int[]{8,10}, 40, Enemy.enemyType.normal, new Item(new int[]{16, 18}, "lzice")));
        Room livingRoom = new RoomImpl("obyvak","Oslepující zlatý lustr ti svítí do očí", new Enemy("Securiťák", new int[]{10,12}, 50, Enemy.enemyType.normal, new Item(new int[]{20, 22}, "teleskopak")));
        Room larder = new RoomImpl("spizirna", "Takového jídla...", new Enemy("Myš", new int[]{1,2}, 10, Enemy.enemyType.normal, new Item("klic")));
        Room workRoom = new RoomImpl("pracoviste", "Ten majitel je fakt tlustej", new Enemy("Majitel", new int[]{12,14}, 70, Enemy.enemyType.boss, null));

        corridor.getFloor().add(new Item( new int[] {3, 5}, "klacek"));

        corridor.registerExit(library);
        library.registerExit(bedroom);
        library.registerExit(corridor);
        bedroom.registerExit(kitchen);
        bedroom.registerExit(library);
        kitchen.registerExit(livingRoom);
        kitchen.registerExit(bedroom);
        livingRoom.registerExit(larder);
        livingRoom.registerExit(workRoom);
        livingRoom.registerExit(kitchen);
        larder.registerExit(livingRoom);
        workRoom.registerExit(livingRoom);

        rooms.add(corridor);
        rooms.add(library);
        rooms.add(bedroom);
        rooms.add(kitchen);
        rooms.add(livingRoom);
        rooms.add(larder);
        rooms.add(workRoom);

        player = new Player();

        this.currentRoom = corridor;
        this.currentRoom.setWasVisited(true);
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
        currentRoom.setWasVisited(true);
    }
    @Override
    public boolean exitRoom(Room room) {
        if(room.isWasVisited()) return true;
        else return false;
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

    @Override
    public Player getPlayer() {
        return player;
    }

}
