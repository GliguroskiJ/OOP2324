package cz.cvut.oop.model;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> inventory;
    private final int inventorySize; //Velikost inventáře lze vždy změnit v konstruktoru playera
    private final ArrayList<InventoryListenerImpl> registeredUsers = new ArrayList<>();

    public Inventory(int size) {
        this.inventory = new ArrayList<>();
        this.inventorySize = size;
    }

    public ArrayList<Item> openInventory() {
        return inventory;
    }

    public void addToInventory (Item item) {
        inventory.add(item);
        notifyRegisteredUsers();
    }
    public void removeFromInventory (Item item){
        inventory.remove(item);
        notifyRegisteredUsers();
    }

    public boolean isSpace () {
        if (inventory.size() < inventorySize) return true;
        else return false;
    }

    public void addRegisteredUser(InventoryListenerImpl listener) {
        this.registeredUsers.add(listener);
    }

    public void removeRegisteredUser(InventoryListenerImpl listener) {
        this.registeredUsers.remove(listener);
    }

    public void notifyRegisteredUsers() {
        for (int i = 0; i < registeredUsers.size(); i++){
            registeredUsers.get(i).update(this);
        }
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
