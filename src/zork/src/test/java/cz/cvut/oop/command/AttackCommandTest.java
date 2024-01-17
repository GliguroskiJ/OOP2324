package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.game.RoomImpl;
import cz.cvut.oop.model.Enemy;
import cz.cvut.oop.model.Item;
import org.junit.Assert;
import org.junit.Test;

public class AttackCommandTest {

    @Test
    public void attackCommand_NoWeapon(){
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1,2}, 50, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Nejprve si nasaď zbraň!"));
        Assert.assertNull(gameData.getPlayer().getWeapon());
    }
    @Test
    public void attackCommand_EnemyAlive_WeaponOn(){
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1,2}, 50, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        gameData.getPlayer().setWeapon(new Item(new int[]{1,1}, "testWeapon1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        int playerHP = gameData.getPlayer().getHealth();
        int enemyHP = gameData.getCurrentRoom().getEnemy().getHealth();

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertNotNull(gameData.getPlayer().getWeapon());
        Assert.assertTrue(playerHP > gameData.getPlayer().getHealth());
        Assert.assertTrue(enemyHP > gameData.getCurrentRoom().getEnemy().getHealth());
        Assert.assertTrue(result.contains("Nepřítel obrdžel 1 bodů poškození a aktuálně má 49 životů\n" +
                "Ty si obdržel 1 bodů poškození a aktuálně máš 129 životů"));
    }
    @Test
    public void attackCommand_EnemyWillDie_WeaponOn() {
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1, 2}, 1, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        gameData.getPlayer().setWeapon(new Item(new int[]{1, 1}, "testWeapon1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        int playerHP = gameData.getPlayer().getHealth();
        int enemyHP = gameData.getCurrentRoom().getEnemy().getHealth();

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertNotNull(gameData.getPlayer().getWeapon());
        Assert.assertTrue(playerHP > gameData.getPlayer().getHealth());
        Assert.assertTrue(enemyHP > gameData.getCurrentRoom().getEnemy().getHealth());
        Assert.assertTrue(result.contains("Nepřítel obrdžel 1 bodů poškození a byl poražen!\n" +
                "Ty si obdržel 1 bodů poškození a aktuálně máš 129 životů"));
    }
    @Test
    public void attackCommand_PlayerWillDie_WeaponOn() {
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1, 1}, 50, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        gameData.getPlayer().setWeapon(new Item(new int[]{1, 1}, "testWeapon1"));
        gameData.getPlayer().setHealth(1);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        int playerHP = gameData.getPlayer().getHealth();
        int enemyHP = gameData.getCurrentRoom().getEnemy().getHealth();

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertNotNull(gameData.getPlayer().getWeapon());
        Assert.assertTrue(playerHP > gameData.getPlayer().getHealth());
        Assert.assertTrue(enemyHP > gameData.getCurrentRoom().getEnemy().getHealth());
        Assert.assertTrue(result.contains("Nepřítel tě zabil!"));
    }
    @Test
    public void attackCommand_NoOneWillDie_WeaponOn() {
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1, 1}, 50, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        gameData.getPlayer().setWeapon(new Item(new int[]{1, 1}, "testWeapon1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        int playerHP = gameData.getPlayer().getHealth();
        int enemyHP = gameData.getCurrentRoom().getEnemy().getHealth();

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertNotNull(gameData.getPlayer().getWeapon());
        Assert.assertTrue(playerHP > gameData.getPlayer().getHealth());
        Assert.assertTrue(enemyHP > gameData.getCurrentRoom().getEnemy().getHealth());
        Assert.assertTrue(result.contains("Nepřítel obrdžel 1 bodů poškození a aktuálně má 49 životů\n" +
                "Ty si obdržel 1 bodů poškození a aktuálně máš 129 životů"));
    }
    @Test
    public void attackCommand_NoEnemy_WeaponOn() {
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        gameData.getPlayer().setWeapon(new Item(new int[]{1, 1}, "testWeapon1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        int playerHP = gameData.getPlayer().getHealth();

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertNotNull(gameData.getPlayer().getWeapon());
        Assert.assertEquals(playerHP, gameData.getPlayer().getHealth());
        Assert.assertTrue(result.contains("Není na koho útočit"));
    }
    @Test
    public void attackCommand_NoEnemy_NoWeapon() {
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        int playerHP = gameData.getPlayer().getHealth();

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertNull(gameData.getPlayer().getWeapon());
        Assert.assertEquals(playerHP, gameData.getPlayer().getHealth());
        Assert.assertTrue(result.contains("Není na koho útočit"));
    }
    @Test
    public void attackCommand_EnemyDead_WeaponOn() {
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1, 1}, 0, Enemy.enemyType.normal, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        gameData.getPlayer().setWeapon(new Item(new int[]{1, 1}, "testWeapon1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        int playerHP = gameData.getPlayer().getHealth();

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertNotNull(gameData.getPlayer().getWeapon());
        Assert.assertEquals(playerHP, gameData.getPlayer().getHealth());
        Assert.assertTrue(gameData.getCurrentRoom().getEnemy().isDead());
        Assert.assertTrue(result.contains("Nepřítel je již po smrti!"));
    }
    @Test
    public void attackCommand_EnemyDead_EnemyTypeBoss_WeaponOn() {
        AttackCommand attack = new AttackCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1", new Enemy("testEnemy1", new int[]{1, 1}, 1, Enemy.enemyType.boss, new Item("testItem1")));
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        gameData.getPlayer().setWeapon(new Item(new int[]{1, 1}, "testWeapon1"));

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        int playerHP = gameData.getPlayer().getHealth();
        int enemyHP = gameData.getCurrentRoom().getEnemy().getHealth();

        String result = attack.execute(null, gameData);
        System.out.println(result + "\n");

        Assert.assertNotNull(gameData.getPlayer().getWeapon());
        Assert.assertTrue(playerHP > gameData.getPlayer().getHealth());
        Assert.assertTrue(enemyHP > gameData.getCurrentRoom().getEnemy().getHealth());
        Assert.assertTrue(gameData.getCurrentRoom().getEnemy().isDead());
        Assert.assertTrue(result.contains("Zabil si bosse a vyhrál si!"));
    }
}
