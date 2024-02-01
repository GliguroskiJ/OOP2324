package cz.cvut.oop.model;

public class EnemyRat implements EnemyStats{
    private static final EnemyRat Instance = new EnemyRat();

    private EnemyRat(){}

    public static EnemyRat getInstance(){
        return Instance;
    }

    public String getName() {
        return "Myš";
    }

    public int[] getDamage() {
        return new int[]{1,2};
    }

    public int getHealth() {
        return 10;
    }
    public Enemy.enemyType getEnemyType() {
        return Enemy.enemyType.normal;
    }
}
