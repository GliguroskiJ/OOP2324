package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import cz.cvut.oop.game.*;
import cz.cvut.oop.game.RoomImpl;
import cz.cvut.oop.model.Enemy;
import cz.cvut.oop.model.Item;
import org.junit.Assert;
import org.junit.Test;

public class LookCommandTest {
    @Test
    public void lookCommandTest_WhenNoEnemy_NoItemOnFloor(){
        LookCommand look = new LookCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String result = look.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Rozhlédl si se po místnosti " + "testRoom1" + "\n" +
                "V inventáři aktuálně nemáš žadný předmět\n" +
                "<------------------------------------------>\n" +
                "[attack] - " + "Zde se nenachází žádný nepřítel" + "\n" +
                "[go 'room'] - " + "testRoom2" + "\n" +
                "[take 'item'] - " + "Na zemi nejsou žádné předměty"));
    }
    @Test
    public void lookCommandTest_WhenEnemyIsAlive_NoItemOnFloor(){
        LookCommand look = new LookCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1",new int[]{0,1}, 10, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String result = look.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Rozhlédl si se po místnosti " + "testRoom1" + "\n" +
                "V inventáři aktuálně nemáš žadný předmět\n" +
                "<------------------------------------------>\n" +
                "[attack] - " + "testEnemy1" + "\n" +
                "[go 'room'] - " + "testRoom2" + "\n" +
                "[take 'item'] - " + "Na zemi nejsou žádné předměty"));
    }
    @Test
    public void lookCommandTest_WhenEnemyIsDead_NoItemOnFloor(){
        LookCommand look = new LookCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1",new int[]{0,1}, 0, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        testRoom1.getEnemy().isDead();

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String result = look.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Rozhlédl si se po místnosti " + "testRoom1" + "\n" +
                "V inventáři aktuálně nemáš žadný předmět\n" +
                "<------------------------------------------>\n" +
                "[attack] - " + "Nepřítel je mrtev" + "\n" +
                "[go 'room'] - " + "testRoom2" + "\n" +
                "[take 'item'] - " + "Na zemi nejsou žádné předměty"));
    }
    @Test
    public void lookCommandTest_WhenNoEnemy_ItemOnFloor(){
        LookCommand look = new LookCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        testRoom1.getFloor().add(new Item("testItem1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String result = look.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Rozhlédl si se po místnosti " + "testRoom1" + "\n" +
                "V inventáři aktuálně nemáš žadný předmět\n" +
                "<------------------------------------------>\n" +
                "[attack] - " + "Zde se nenachází žádný nepřítel" + "\n" +
                "[go 'room'] - " + "testRoom2" + "\n" +
                "[take 'item'] - " + "testItem1"));
    }
    @Test
    public void lookCommandTest_WhenEnemyIsAlive_ItemOnFloor(){
        LookCommand look = new LookCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1",new int[]{0,1}, 10, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        testRoom1.getFloor().add(new Item("testItem1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String result = look.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Rozhlédl si se po místnosti " + "testRoom1" + "\n" +
                "V inventáři aktuálně nemáš žadný předmět\n" +
                "<------------------------------------------>\n" +
                "[attack] - " + "testEnemy1" + "\n" +
                "[go 'room'] - " + "testRoom2" + "\n" +
                "[take 'item'] - " + "testItem1"));
    }
    @Test
    public void lookCommandTest_WhenEnemyIsDead_ItemOnFloor(){
        LookCommand look = new LookCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1",new int[]{0,1}, 0, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        testRoom1.getFloor().add(new Item("testItem1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String result = look.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Rozhlédl si se po místnosti " + "testRoom1" + "\n" +
                "V inventáři aktuálně nemáš žadný předmět\n" +
                "<------------------------------------------>\n" +
                "[attack] - " + "Nepřítel je mrtev" + "\n" +
                "[go 'room'] - " + "testRoom2" + "\n" +
                "[take 'item'] - " + "testItem1"));
    }
    @Test
    public void lookCommandTest_ItemInInventory(){
        LookCommand look = new LookCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1",new int[]{0,1}, 10, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        gameData.getPlayer().getInventory().openInventory().add(new Item("testItem1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String result = look.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Rozhlédl si se po místnosti " + "testRoom1" + "\n" +
                "V inventáři máš aktuálně testItem1\n" +
                "<------------------------------------------>\n" +
                "[attack] - " + "testEnemy1" + "\n" +
                "[go 'room'] - " + "testRoom2" + "\n" +
                "[take 'item'] - " + "Na zemi nejsou žádné předměty"));
    }

}
