package cz.cvut.oop.model;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> inventory;
    private final int inventorySize = 4; //Velikost inventáře lze vždy změnit

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Item> openInventory() {
        return inventory;
    }

    public void addToInventory (Item item) {
        inventory.add(item);
    }

    public boolean isSpace () {
        if (inventory.size() < inventorySize) return true;
        else return false;
    }

    public String listItemsInInventory() {
        ArrayList<String> itemNames = new ArrayList<>();
        if (openInventory().isEmpty()) return "V inventáři aktuálně nemáš žadný předmět";
        else {
            for (Item item : inventory) {
                itemNames.add(item.getName());
            }
            return "V inventáři máš aktuálně " + String.join(", ", itemNames);
        }
    }
}
