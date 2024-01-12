package cz.cvut.oop.model;

import java.util.Random;

public class Enemy {
    private String name;
    private int[] damage;
    private int health;
    private boolean dead;

    public Enemy(String name, int[] damage, int health) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.dead = false;
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
}
