package cz.cvut.oop.model;

public class Item {
    private int damageFrom;
    private int damageTo;
    private String name;
    private itemType type;
    private enum itemType {weapon, key}

    public Item(int damageFrom, int damageTo, String name) {
        this.damageFrom = damageFrom;
        this.damageTo = damageTo;
        this.name = name;
        this.type = itemType.weapon;
    }

    public Item(String name) {
        this.damageFrom = 0;
        this.damageTo = 0;
        this.name = name;
        this.type = itemType.key;
    }

    public int getDamageFrom() {
        return damageFrom;
    }

    public int getDamageTo() {
        return damageTo;
    }

    public String getName() {
        return name;
    }

    public itemType getType() {
        return type;
    }
}
