package cz.cvut.oop.model;

import cz.cvut.oop.command.Command;

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
        Item startWeapon = new Item(1, 4, "Dřevěná tyčka");
        inventory.addToInventory(startWeapon);
        return startWeapon;
    }

}
