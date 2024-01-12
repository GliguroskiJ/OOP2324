package cz.cvut.oop.model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory;
    private int inventorySize = 4; //Velikost inventáře lze vždy změnit

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addToInventory (Item item) {
        if (inventory.size() < inventorySize) {
            inventory.add(item);
        }
        else{
            System.out.println("Není dostatek místa v inventáři, nejprve něco odlož.");
        }
    }
}
