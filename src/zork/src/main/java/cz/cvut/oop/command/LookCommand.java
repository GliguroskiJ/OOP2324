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

        if (gameData.getCurrentRoom().isEnemyNull()) enemyVypis = "Zde se nenachází žádný nepřítel";
        else if (gameData.getCurrentRoom().getEnemy().isDead()) {
            enemyVypis = "Nepřítel je mrtev";
        } else enemyVypis = gameData.getCurrentRoom().getEnemy().getName();

        return "Rozhlédl si se po místnosti " + gameData.getCurrentRoom().getName() + "\n" +
                "Komentář k místnosti: " + gameData.getCurrentRoom().getDescription() + "\n" +
                gameData.getPlayer().getInventory().listItemsInInventory() + "\n" +
                "<------------------------------------------------------>\n" +
                "[attack] - " + enemyVypis + "\n" +
                "[go 'room'] - " + gameData.getCurrentRoom().getDescriptionWithExits() + "\n" +
                "[take 'item'] - " + gameData.getCurrentRoom().lookOnFloor();
    }
}
