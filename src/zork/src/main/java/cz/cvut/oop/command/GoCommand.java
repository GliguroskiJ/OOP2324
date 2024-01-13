package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.model.Enemy;
import cz.cvut.oop.model.Player;

import java.util.Objects;

public class GoCommand implements Command{
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
        } else if (gameData.getCurrentRoom().getExitByName(roomName).isEnemyNull()) {
            int healthAfterAttack;
            int enemyDamage = enemy.getDamage();
            player.setHealth(player.getHealth()-enemyDamage);
            healthAfterAttack = player.getHealth();

            gameData.setCurrentRoom(exitByName);
            return "Přesunut do místnosti " + roomName + "\n" +
                    "Obdržel si " + enemyDamage + " bodů poškození a aktuálně máš " + healthAfterAttack + " životů";
        } else if (gameData.getCurrentRoom().getEnemy() == null) {
            gameData.setCurrentRoom(exitByName);
            return "Přesunut do místnosti " + roomName;
                    //gameData.getCurrentRoom().toString();
        } else if (!gameData.getCurrentRoom().getEnemy().isDead() && (gameData.exitRoom(exitByName))) {
            int healthAfterAttack;
            int enemyDamage = enemy.getDamage();
            player.setHealth(player.getHealth()-enemyDamage);
            healthAfterAttack = player.getHealth();

            gameData.setCurrentRoom(exitByName);
            return "Přesunut do místnosti " + roomName + "\n" +
                    "Obdržel si " + enemyDamage + " bodů poškození a aktuálně máš " + healthAfterAttack + " životů";
        } else if (!gameData.getCurrentRoom().getEnemy().isDead()) {
            return "Nejprve se musíš dostat přes nepřítele, který ti stojí v cestě!";
        } else if (gameData.getCurrentRoom().getExitByName(roomName).getEnemy().getType() == Enemy.enemyType.boss) {
            if (!player.getInventory().openInventory().contains(gameData.getCurrentRoom().getExitByName("spizirna").getEnemy().dropItem())) {
                return "Ke vstupu do místnosti potřebuješ klíč!";
            }
            else {
                gameData.setCurrentRoom(exitByName);
                return "Přesunut do místnosti " + roomName;
                        //gameData.getCurrentRoom().toString();
            }
        } else {
            gameData.setCurrentRoom(exitByName);
            return "Přesunut do místnosti " + roomName;
                    //gameData.getCurrentRoom().toString();
        }

        /*else if (!gameData.getCurrentRoom().getEnemy().isDead() && (player.getWeapon() == null)) {
            gameData.setCurrentRoom(exitByName);
            return "Přesunut do místnosti " + roomName +
                    "Ty si obdržel " + damageToPlayer + " bodů poškození a aktuálně máš " + player.getHealth() + " životů";
        }*/
    }
}
