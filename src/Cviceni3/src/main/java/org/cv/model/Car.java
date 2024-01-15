package org.cv.model;

public class Car {
    private String brand;
    private String engine;
    private String color;
    private int year;

    public Car(String brand, String engine, String color, int year) {
        this.brand = brand;
        this.engine = engine;
        this.color = color;
        this.year = year;
    }

    public void changeColor(String color)
    {
        this.color=color;
    }

    @Override
    public String toString() {
        return String.format("Auto znacky: %s s motorem: %s ma barvu %s a je z roku %d",brand,engine,color,year);
    }
}
