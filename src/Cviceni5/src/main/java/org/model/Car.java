package org.model;

public class Car {
    protected String color;
    protected int year;
    protected int numOfWheels;

    public Car(String color, int year, int numOfWheels) {
        this.color = color;
        this.year = year;
        this.numOfWheels = numOfWheels;
    }

    public  String example()
    {
        return "Ahoj Svete";
    }
    public String returnColor()
    {
        return String.format("Auto je barvy:%s",this.color);
    }

    @Override
    public String toString() {
        return "Moje auto z Car";
    }
}
