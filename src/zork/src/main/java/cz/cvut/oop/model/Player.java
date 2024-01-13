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
        this.weapon = addStartWeapon();
    }

    public Item addStartWeapon() {
        Item startWeapon = new Item( new int[] {2,5}, "klacek");
        //inventory.addToInventory(startWeapon);
        return startWeapon;
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
        Item curentWeapon = inventory.getInventory().get(0);
        this.weapon = item;
        return curentWeapon;
    }
}
