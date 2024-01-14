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
        testRoom1.getFloor().add(new Item("testItem1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"take", "testItem1"};
        String result = take.execute(userInput, gameData);
        System.out.println(result + "\n");
        Assert.assertTrue(result.contains("V inventáři máš aktuálně testItem1\n" +
                "Předmět testItem1 byl přidán do inventáře"));
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
}
