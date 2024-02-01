package cz.cvut.oop.model;

public interface EnemyStats {
    String getName();
    int[] getDamage();
    int getHealth();
    Enemy.enemyType getEnemyType();
}
