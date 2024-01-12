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
        Item startWeapon = new Item( new int[] {1,4}, "Dřevěná tyčka");
        //inventory.addToInventory(startWeapon);
        //EquipCommand com = new EquipCommand(startWeapon);
        return startWeapon;
    }

    public int getDamage() {
        return (int) ((Math.random() * (weapon.getDamage()[0] - weapon.getDamage()[1])) + weapon.getDamage()[0]);
    }

}
