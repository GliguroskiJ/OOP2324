package cz.cvut.oop.model;

import cz.cvut.oop.command.*;

import java.util.Random;

public class Player {
    private int health;
    private Inventory inventory;
    private Item weapon;

    public Player() {
        this.health = 100;
        this.inventory = new Inventory();
        this.weapon = null;
    }

    public int getDamage() {
        //return (int) ((Math.random() * (weapon.getDamage()[1] - weapon.getDamage()[0])) + weapon.getDamage()[0]);
        return 1000;
    }

    public Item getWeapon() {
        return weapon;
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

    public Inventory getInventory() {
        return inventory;
    }

    public Item swapWeapons (Item item){
        if (weapon == null ) {
            this.weapon = item;
            return weapon;
        }
        else {
            Item curentWeapon = weapon;
            this.weapon = item;
            inventory.addToInventory(curentWeapon);
            return weapon;
        }
    }
}
