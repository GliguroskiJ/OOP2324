package org.decorator;

public class SimpleCoffee implements Coffee{
    @Override
    public String prepareCoffee() {
        return "Kava";
    }

    @Override
    public double getCost() {
        return 40;
    }
}
