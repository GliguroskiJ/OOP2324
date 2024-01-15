package org.flyweight;

public class Car {
    private CarType type;
    private String color;

    public Car(CarType type, String color) {
        this.type = type;
        this.color = color;
    }

    public CarType getType() {
        return type;
    }

    public String getColor() {
        return color;
    }
}
