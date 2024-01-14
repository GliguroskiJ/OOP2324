package cz.cvut.oop.model;

import cz.cvut.oop.game.GameData;
import cz.cvut.oop.game.Room;

public class Enemy {
    private String name;
    private int[] damage;
    private int health;
    private enemyType type;
    private Item itemDrop;
    public enum enemyType {normal, boss}

    public Enemy(String name, int[] damage, int health, enemyType type, Item itemDrop) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.type = type;
        this.itemDrop = itemDrop;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return (int) ((Math.random() * (damage[1] - damage[0])) + damage[0]);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        if (health <= 0) return true;
        return false;
    }

    public enemyType getType() {
        return type;
    }

    public Item dropItem() {
        return itemDrop;
    }

    public String lookForEnemy() {
        if (isDead()) return "Nepřítel je mrtev";
        else if (!isDead()) return name;
        else return "Zde se nenachází žádný nepřítel";
    }

    public String onlyEnemyDealDamage(GameData gameData, Room exitByName) {
        if ((!this.isDead()) && (exitByName != null)){
            Enemy enemy = gameData.getCurrentRoom().getEnemy();
            Player player = gameData.getPlayer();

            int healthAfterAttack;
            int enemyDamage = enemy.getDamage();
            player.setHealth(player.getHealth()-enemyDamage);
            healthAfterAttack = player.getHealth();

            gameData.setCurrentRoom(exitByName);

            return "Obdržel si " + enemyDamage + " bodů poškození a aktuálně máš " + healthAfterAttack + " životů\n";
        } else if ((!this.isDead()) && (exitByName == null)) {
            Enemy enemy = gameData.getCurrentRoom().getEnemy();
            Player player = gameData.getPlayer();

            int healthAfterAttack;
            int enemyDamage = enemy.getDamage();
            player.setHealth(player.getHealth()-enemyDamage);
            healthAfterAttack = player.getHealth();

            return "Obdržel si " + enemyDamage + " bodů poškození a aktuálně máš " + healthAfterAttack + " životů\n";
        }
        else return "";
    }

}
