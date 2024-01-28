package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.game.RoomImpl;
import cz.cvut.oop.model.Item;
import org.junit.Assert;
import org.junit.Test;

public class EquipCommandTest {
    @Test
    public void equipItemFromInventory_InInventory_NoEquipedWeapon(){
        EquipCommand equip = new EquipCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        Item testItemToEquip = new Item(new int[]{0,1}, "testItemToEquip");
        gameData.getPlayer().getInventory().openInventory().add(testItemToEquip);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"equip", "testItemToEquip"};
        String result = equip.execute(userInput, gameData);
        //System.out.println(result + "\n");

        Assert.assertTrue(gameData.getPlayer().getWeapon().getName().contains(testItemToEquip.getName()));
        Assert.assertTrue(result.contains("Do ruky sis dal předmět testItemToEquip se sílou útoku od 0 do 1"));
    }
    @Test
    public void equipItemFromInventory_InInventory_EquipedWeapon(){
        EquipCommand equip = new EquipCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        Item testItemEquiped = new Item(new int[]{0,1}, "testItemEquiped");
        Item testItemToEquip = new Item(new int[]{0,1}, "testItemToEquip");
        gameData.getPlayer().setWeapon(testItemEquiped);
        gameData.getPlayer().getInventory().openInventory().add(testItemToEquip);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"equip", "testItemToEquip"};
        String result = equip.execute(userInput, gameData);
        //System.out.println(result + "\n");

        //Je vybraná zbraň nasazená?
        Assert.assertTrue(gameData.getPlayer().getWeapon().getName().contains(testItemToEquip.getName()));
        //Je původní zbraň v inventáři?
        Assert.assertTrue(gameData.getPlayer().getInventory().openInventory().contains(testItemEquiped));
    }
    @Test
    public void equipItemFromInventory_NotInInventory(){
        EquipCommand equip = new EquipCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        Item testItem1 = new Item(new int[]{0,1}, "testItemEquiped");
        gameData.getPlayer().getInventory().openInventory().add(testItem1);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"equip", "test"};
        String result = equip.execute(userInput, gameData);
        //System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Takový předmět v inventáři nemáš"));
    }
    @Test
    public void equipItemFromInventory_EmptyInventory(){
        EquipCommand equip = new EquipCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"equip", "test"};
        String result = equip.execute(userInput, gameData);
        //System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Máš prázdný inventář"));
    }
    @Test
    public void equipItemFromInventory_ItemIsTypeKey(){
        EquipCommand equip = new EquipCommand();
        GameDataImpl gameData = new GameDataImpl();
        Room testRoom1 = new RoomImpl("testRoom1", "testPopisek1");
        Room testRoom2 = new RoomImpl("testRoom2", "testPopisek2");
        Item testItem1 = new Item("testItem1");
        gameData.getPlayer().getInventory().openInventory().add(testItem1);

        testRoom1.registerExit(testRoom2);
        testRoom1.setWasVisited(true);
        gameData.setCurrentRoom(testRoom1);

        String[] userInput = {"equip", "testItem1"};
        String result = equip.execute(userInput, gameData);
        //System.out.println(result + "\n");

        Assert.assertTrue(result.contains("Tento předmět si nemůžeš nasadit"));
    }
}
