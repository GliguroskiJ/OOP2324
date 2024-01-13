package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;

public class LookCommand implements Command{
    @Override
    public String getName() {
        return "look";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        String enemyVypis;

        if (gameData.getCurrentRoom().getEnemy() == null) enemyVypis = "Zde se nenachází žádný nepřítel"; //nefukční
        else enemyVypis = gameData.getCurrentRoom().getName();

        return "Rozhlédl si se po místnosti " + enemyVypis + "\n" +
                "Komentář k místnosti: " + gameData.getCurrentRoom().getDescription() + "\n" +
                gameData.getPlayer().getInventory().listItemsInInventory() + "\n" +
                "<------------------------------------------------------>\n" +
                "[attack] - " + gameData.getCurrentRoom().getEnemy().lookForEnemy() + "\n" +
                "[go 'room'] - " + gameData.getCurrentRoom().getDescriptionWithExits() + "\n" +
                "[take 'item'] - " + gameData.getCurrentRoom().lookOnFloor() + "\n" +
                "[equip 'item'] - Nasadíš si předmět z inventáře\n" +
                "[drop 'item'] - Položíš předmět z inventáře na zem";
    }
}
