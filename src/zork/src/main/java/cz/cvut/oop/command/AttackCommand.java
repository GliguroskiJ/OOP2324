package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.model.*;

public class AttackCommand implements Command {

    @Override
    public String getName() {
        return "attack";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        Player player = gameData.getPlayer();
        Enemy enemy = gameData.getCurrentRoom().getEnemy();


        if ((player.getWeapon() != null) && (gameData.getCurrentRoom().isEnemyNull())) return "Není na koho útočit";

        if((player.getWeapon() != null) && (!enemy.isDead()) && (!player.isDead()) && !gameData.getCurrentRoom().isEnemyNull()){
            int damageToEnemy = player.getDamage();
            int damageToPlayer = enemy.getDamage();

            int enemyRecievedDmg = enemy.getHealth() - damageToEnemy;
            int playerRecievedDmg = player.getHealth() - damageToPlayer;

            enemy.setHealth(enemyRecievedDmg);
            player.setHealth(playerRecievedDmg);

            if (enemy.isDead() && (enemy.getType() == Enemy.enemyType.boss)) {
                gameData.setFinished(true);
                return "Zabil si bosse a vyhrál si!";
            }
            else if (enemy.isDead()) {
                gameData.getCurrentRoom().getFloor().add(enemy.dropItem());
                return "Nepřítel obrdžel " + damageToEnemy + " bodů poškození a byl poražen!\n" +
                        "Ty si obdržel " + damageToPlayer + " bodů poškození a aktuálně máš " + player.getHealth() + " životů";
            } else if (player.isDead()) {
                gameData.setFinished(true);
                return "Nepřítel tě zabil!\n";

            } else return "Nepřítel obrdžel " + damageToEnemy + " bodů poškození a aktuálně má " + enemy.getHealth() + " životů\n" +
                    "Ty si obdržel " + damageToPlayer + " bodů poškození a aktuálně máš " + player.getHealth() + " životů";
        } else if (gameData.getCurrentRoom().isEnemyNull()) {
            return "Není na koho útočit";
        } else if (enemy.isDead()) {
            return "Nepřítel je již po smrti!";
        } else return "Nejprve si nasaď zbraň!";
    }
}
