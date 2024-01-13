package cz.cvut.oop.model;

import java.util.Random;

public class Enemy {
    private String name;
    private int[] damage;
    private int health;
    private boolean dead;
    private enemyType type;
    private Item itemDrop;
    public enum enemyType {normal, boss}

    public Enemy(String name, int[] damage, int health, enemyType type, Item itemDrop) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.dead = false;
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

    public void setDead() {
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public enemyType getType() {
        return type;
    }

    public Item dropItem() {
        return itemDrop;
    }
}
