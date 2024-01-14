package cz.cvut.oop.model;

import java.util.Map;

public class Player {
    private int health;
    private final Inventory inventory;
    private Item weapon;

    public Player() {
        this.health = 130;
        this.inventory = new Inventory(4);
        this.weapon = null;
    }

    public int getDamage() {
        return (int) ((Math.random() * (weapon.getDamage()[1] - weapon.getDamage()[0])) + weapon.getDamage()[0]);
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
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
        } else {
            Item curentWeapon = weapon;
            this.weapon = item;
            this.getInventory().openInventory().add(curentWeapon);
            return weapon;
        }
    }

    public String weaponChange (Map<String, Item> inventoryMap, String weaponToEquip) {
        Item weapon;
        Item newWeapon;

        weapon = inventoryMap.get(weaponToEquip);
        newWeapon = swapWeapons(weapon);
        this.getInventory().removeFromInventory(inventoryMap.get(weaponToEquip));
        inventoryMap.remove(weaponToEquip);

        return "Do ruky sis dal předmět " + newWeapon.getName() + " se sílou útoku od " + newWeapon.getDamage()[0] + " do " + newWeapon.getDamage()[1];
    }
}
