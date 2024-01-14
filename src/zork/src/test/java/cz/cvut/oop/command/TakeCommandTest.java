package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.game.RoomImpl;
import cz.cvut.oop.model.Item;
import org.junit.Assert;
import org.junit.Test;

public class TakeCommandTest {
    @Test
    public void takeCommandTest_TakeItemFromFloor(){
        TakeCommand take = new TakeCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        Item testItem1 = new Item("testItem1");
        testRoom1.getFloor().add(testItem1);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"take", "testItem1"};
        String result = take.execute(userInput, gameData);
        System.out.println(result + "\n");
        Assert.assertTrue(gameData.getPlayer().getInventory().openInventory().contains(testItem1));
    }
    @Test
    public void takeCommandTest_NoChosenItemOnFloor(){
        TakeCommand take = new TakeCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        testRoom1.getFloor().add(new Item("testItem1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"take", "test"};
        String result = take.execute(userInput, gameData);
        System.out.println(result + "\n");
        Assert.assertTrue(result.contains("Takový předmět na zemi není"));
    }
    @Test
    public void takeCommandTest_TakeItemFromFloor_FullInventory(){
        TakeCommand take = new TakeCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        testRoom1.getFloor().add(new Item("testItem1"));
        gameData.getPlayer().getInventory().openInventory().add(new Item("testItem2"));
        gameData.getPlayer().getInventory().openInventory().add(new Item("testItem3"));
        gameData.getPlayer().getInventory().openInventory().add(new Item("testItem4"));
        gameData.getPlayer().getInventory().openInventory().add(new Item("testItem5"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"take", "testItem1"};
        String result = take.execute(userInput, gameData);
        System.out.println(result + "\n");
        Assert.assertTrue(result.contains("Máš plný batoh. Nejprve něco odlož"));
    }
}
