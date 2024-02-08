package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.model.Enemy;
import cz.cvut.oop.model.Player;

public class GoCommand implements Command{
    LookCommand look = new LookCommand();
    @Override
    public String getName() {
        return "go";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        if (arguments.length < 2) return "Špatně zadaný příkaz. Pro více info použij příkaz [help]";

        Enemy enemy = gameData.getCurrentRoom().getEnemy();
        Player player = gameData.getPlayer();
        String roomName = arguments[1];
        Room exitByName = gameData.getCurrentRoom().getExitByName(roomName);

        if(exitByName == null){
            return "Takový exit neexistuje";

        } else if (gameData.getCurrentRoom().getExitByName(roomName).isEnemyNull() && !gameData.getCurrentRoom().getEnemy().isDead()) {
            return "Nejprve se musíš dostat přes nepřítele, který ti stojí v cestě!\n" +
                    enemy.onlyEnemyDealDamage(gameData, null);

        } else if (gameData.getCurrentRoom().getExitByName(roomName).isEnemyNull()) {
            gameData.setCurrentRoom(exitByName);
            return "Přesunul si se do místnosti " + roomName + "\n" +
                    enemy.onlyEnemyDealDamage(gameData, exitByName) +
                    roomInfo(gameData) +
                    lookCommandExec(gameData);

        } else if (gameData.getCurrentRoom().getEnemy() == null) {
            gameData.setCurrentRoom(exitByName);
            return "Přesunul si se do místnosti " + roomName + "\n" +
                    roomInfo(gameData) +
                    lookCommandExec(gameData);

        } else if (!gameData.getCurrentRoom().getEnemy().isDead() && (gameData.exitRoom(exitByName))) {
            return "Nejprve se musíš dostat přes nepřítele, který ti stojí v cestě!\n" +
                    enemy.onlyEnemyDealDamage(gameData, null);

        } else if (!gameData.getCurrentRoom().getEnemy().isDead()) {
            return "Nejprve se musíš dostat přes nepřítele, který ti stojí v cestě!\n" +
                    enemy.onlyEnemyDealDamage(gameData, null);

        } else if (gameData.getCurrentRoom().getExitByName(roomName).getEnemy().getType() == Enemy.enemyType.boss) {
            if (!player.getInventory().openInventory().contains(gameData.getCurrentRoom().getExitByName("spizirna").getEnemy().dropItem())) {
                return "Ke vstupu do místnosti potřebuješ klíč!";

            } else {
                gameData.setCurrentRoom(exitByName);
                return "Přesunul si se do místnosti " + roomName + "\n" +
                        roomInfo(gameData) +
                        lookCommandExec(gameData);

            }
        } else {
            gameData.setCurrentRoom(exitByName);
            return "Přesunul si se do místnosti " + roomName + "\n" +
                    roomInfo(gameData) +
                    lookCommandExec(gameData);

        }
    }

    public String roomInfo(GameData gameData){
        if (gameData.getPlayer().getWeapon() == null){
            return "Komentář k místnosti: " + gameData.getCurrentRoom().getDescription() + "\n" +
                    "V ruce nemáš žádný předmět" + "\n";

        }
        else return "Komentář k místnosti: " + gameData.getCurrentRoom().getDescription() + "\n" +
                "V ruce máš " + gameData.getPlayer().getWeapon().getName() + " s poškozením od " + gameData.getPlayer().getWeapon().getDamage()[0] + " do " + gameData.getPlayer().getWeapon().getDamage()[1] + "\n" ;
    }

    public String lookCommandExec(GameData gameData) {
        return look.execute(null, gameData);
    }
}
