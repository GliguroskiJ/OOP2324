package cz.cvut.oop.model;

public class Item {
    private int[] damage = new int[2];
    private String name;
    private itemType type;
    public enum itemType {weapon, key};

    public Item(int[] damage, String name) {
        this.damage = damage;
        this.name = name;
        this.type = itemType.weapon;
    }

    public Item(String name) {
        this.name = name;
        this.type = itemType.key;
    }

    public int[] getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public itemType getType() {
        return type;
    }
}
