package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.game.RoomImpl;
import cz.cvut.oop.model.Item;
import org.junit.Assert;
import org.junit.Test;

public class DropCommandTest {
    @Test
    public void dropCommandTest_DropChosenItem_ItemInInventory(){
        DropCommand drop = new DropCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        Item testItem1 = new Item("testItem1");
        gameData.getPlayer().getInventory().openInventory().add(testItem1);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"drop", "testItem1"};
        String result = drop.execute(userInput, gameData);
        //System.out.println(result + "\n");

        //Item byl dropnut na zem a je na zemi místnosti
        Assert.assertTrue(gameData.getCurrentRoom().getFloor().contains(testItem1));
        //Dropnutý item už není v hračově inventáři
        Assert.assertFalse(gameData.getPlayer().getInventory().openInventory().contains(testItem1));
    }
    @Test
    public void dropCommandTest_DropChosenItem_ItemNotInInventory(){
        DropCommand drop = new DropCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        Item testItem1 = new Item("testItem1");
        gameData.getPlayer().getInventory().openInventory().add(testItem1);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"drop", "test"};
        String result = drop.execute(userInput, gameData);
        //System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Takový předmět v inventáři nemáš"));
    }
    @Test
    public void dropCommandTest_DropChosenItem_EmptyInventory(){
        DropCommand drop = new DropCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"drop", "testItem1"};
        String result = drop.execute(userInput, gameData);
        //System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Máš prázdný inventář"));
    }
}
