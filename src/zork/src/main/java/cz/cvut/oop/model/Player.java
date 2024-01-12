package cz.cvut.oop.model;

import cz.cvut.oop.command.*;

import java.util.Random;

public class Player {
    private int health;
    private Inventory inventory;
    private Item weapon;
    private boolean dead;

    public Player() {
        this.health = 100;
        this.inventory = new Inventory();
        this.weapon = addStartWeapon();
        this.dead = false;
    }

    public Item addStartWeapon() {
        Item startWeapon = new Item( new int[] {2,5}, "Dřevěná tyčka");
        //inventory.addToInventory(startWeapon);
        //EquipCommand com = new EquipCommand(startWeapon);
        return startWeapon;
    }

    public int getDamage() {
        return (int) ((Math.random() * (weapon.getDamage()[1] - weapon.getDamage()[0])) + weapon.getDamage()[0]);
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
        return dead;
    }

    public void setDead() {
        this.dead = true;
    }


}
