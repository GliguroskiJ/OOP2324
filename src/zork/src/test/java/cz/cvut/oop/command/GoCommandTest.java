package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.game.RoomImpl;
import cz.cvut.oop.model.Enemy;
import cz.cvut.oop.model.Item;
import org.junit.Assert;
import org.junit.Test;

public class GoCommandTest {
    @Test
    public void goRoomNotExisting(){
        GoCommand go = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"go", "testItem1"};
        String result = go.execute(userInput, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Takový exit neexistuje"));
    }
    @Test
    public void goRoomNotChosen(){
        GoCommand go = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"go"};
        String result = go.execute(userInput, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Špatně zadaný příkaz. Pro více info použij příkaz [help]"));
    }
    @Test
    public void goRoom_EnemyIsNull(){
        GoCommand go = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1,1}, 0, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"go", "testRoom2"};
        String result = go.execute(userInput, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Přesunul si se do místnosti testRoom2\n" +
                "Komentář k místnosti: testPopisek1\n" +
                "V ruce nemáš žádný předmět\n" +
                "V inventáři aktuálně nemáš žadný předmět"));
    }
    @Test
    public void goRoom_EnemyIsAlive(){
        GoCommand go = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1,1}, 10, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2", new Enemy("testEnemy1", new int[]{1,1}, 10, Enemy.enemyType.normal, new Item("testItem2")));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"go", "testRoom2"};
        String result = go.execute(userInput, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Nejprve se musíš dostat přes nepřítele, který ti stojí v cestě!"));
    }
    @Test
    public void goRoom_EnemyIsBoss_PlayerHasNoKey(){
        GoCommand go = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1,1}, 0, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("spizirna", "spizirna", new Enemy("testEnemy1", new int[]{1,1}, 10, Enemy.enemyType.boss, new Item("testItem2")));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"go", "spizirna"};
        String result = go.execute(userInput, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Ke vstupu do místnosti potřebuješ klíč!"));
    }
    @Test
    public void goRoom_EnemyIsBoss_PlayerHasKey(){
        GoCommand go = new GoCommand();
        GameDataImpl gameData = new GameDataImpl();
        Item keyTest1 = new Item("keyTest1");
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1,1}, 0, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("spizirna", "spizirna", new Enemy("testEnemy1", new int[]{1,1}, 10, Enemy.enemyType.boss, keyTest1));
        gameData.getPlayer().getInventory().openInventory().add(keyTest1);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"go", "spizirna"};
        String result = go.execute(userInput, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Přesunul si se do místnosti spizirna\n" +
                "Komentář k místnosti: spizirna\n" +
                "V ruce nemáš žádný předmět\n" +
                "V inventáři máš aktuálně keyTest1"));
    }
}
