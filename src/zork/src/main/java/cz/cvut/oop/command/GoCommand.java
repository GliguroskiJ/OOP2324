package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Room;
import cz.cvut.oop.model.Enemy;
import cz.cvut.oop.model.Player;

public class GoCommand implements Command{
    @Override
    public String getName() {
        return "go";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        Player player = gameData.getPlayer();
        String roomName = arguments[1];
        Room exitByName = gameData.getCurrentRoom().getExitByName(roomName);

        if(exitByName == null){
            return "Takový exit neexistuje";
        }
        else if (gameData.getCurrentRoom().getEnemy() == null) {
            gameData.setCurrentRoom(exitByName);
            return "Přesunut do místnosti " + roomName;
                    //gameData.getCurrentRoom().toString();
        }
        else if (!gameData.getCurrentRoom().getEnemy().isDead()) {
            return "Nejprve se musíš dostat přes nepřítele, který ti stojí v cestě!";
        }
        else if (gameData.getCurrentRoom().getExitByName(roomName).getEnemy().getType() == Enemy.enemyType.boss) {
            if (!player.getInventory().getInventory().contains(gameData.getCurrentRoom().getExitByName("spizirna").getEnemy().dropItem())) {
                return "Ke vstupu do místnosti potřebuješ klíč!";
            }
            else {
                gameData.setCurrentRoom(exitByName);
                return "Přesunut do místnosti " + roomName;
                        //gameData.getCurrentRoom().toString();
            }
        }
        else {
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
