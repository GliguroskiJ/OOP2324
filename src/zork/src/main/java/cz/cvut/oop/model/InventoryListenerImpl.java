package cz.cvut.oop.model;

import java.util.ArrayList;

public class InventoryListenerImpl implements InventoryListener{
    public void update(Inventory inventory) {
        ArrayList<String> itemNames = new ArrayList<>();
        if (inventory.openInventory().isEmpty()) System.out.println("V inventáři aktuálně nemáš žadný předmět");
        else {
            for (Item item : inventory.openInventory()) {
                itemNames.add(item.getName());
            }
            System.out.println("V inventáři máš aktuálně " + String.join(", ", itemNames));
        }
    }
}
