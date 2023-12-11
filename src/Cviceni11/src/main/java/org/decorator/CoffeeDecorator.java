package org.decorator;

public class CoffeeDecorator implements Coffee{

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public String prepareCoffee() {
        return this.coffee.prepareCoffee();
    }

    @Override
    public double getCost() {
        return this.coffee.getCost();
    }
}
