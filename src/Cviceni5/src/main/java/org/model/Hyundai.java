package org.model;

public class Hyundai extends Car{

    private int price;
    private String engine;
//    Constructor 0
    public Hyundai(String color, int year, int numOfWheels, int price, String engine) {
        super(color, year, numOfWheels);
        this.price=price;
        this.engine=engine;
    }
//Constructor 1 - overloaded
    public Hyundai(String color, int year, int numOfWheels, String engine) {
        super(color, year, numOfWheels);
        this.engine = engine;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String returnColor()
    {
        return String.format("Barva ze tridy Hyundai je:%s",this.color);
    }

    @Override
    public String toString() {
        return "Moje auto z hyundai";
    }
}
