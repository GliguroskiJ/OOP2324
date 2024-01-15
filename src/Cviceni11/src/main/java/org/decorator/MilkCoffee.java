package org.decorator;

public class MilkCoffee extends CoffeeDecorator{
    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String prepareCoffee() {
        return super.prepareCoffee()+", s mlekem";
    }

    @Override
    public double getCost() {
        return super.getCost()+5;
    }
}
