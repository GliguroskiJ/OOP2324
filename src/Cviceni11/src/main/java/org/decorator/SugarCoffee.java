package org.decorator;

public class SugarCoffee extends CoffeeDecorator{
    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String prepareCoffee() {
        return super.prepareCoffee()+", s cukrem";
    }

    @Override
    public double getCost() {
        return super.getCost()+6;
    }
}
