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
        inventory.add(item);
    }

    public boolean isSpace () {
        if (inventory.size() < inventorySize) return true;
        else return false;
    }

    public void removeFromInventory (Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
        }
        else System.out.println("Tento item nemáš v inventáři");
    }

    public String listItemsInInventory() {
        ArrayList<String> itemNames = new ArrayList<>();
        if (getInventory().isEmpty()) return "V inventáři aktuálně nemáš žadný předmět";
        else {
            for (int i = 0; i < inventory.size(); i++){
                itemNames.add(inventory.get(i).getName());
            }
            return "V inventáři máš aktuálně " + String.join(", ", itemNames);
        }
    }
}
