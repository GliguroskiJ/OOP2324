package cz.cvut.oop.model;

public class EnemyBuilder {
    private Item enemyItem;
    private EnemyStats enemyStats;

    public EnemyBuilder(EnemyStats enemyStats) {
        this.enemyStats = enemyStats;
    }

    public static EnemyBuilder createMouse() {
        return new EnemyBuilder(EnemyRat.getInstance());
    }

    public EnemyBuilder withLoot(Item item){
        enemyItem = item;
        return this;
    }

    public Enemy build(){
        return new Enemy(enemyStats, enemyItem);
    }
}
