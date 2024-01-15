package org.decorator;

public class SugarMilkCoffee extends CoffeeDecorator{
    public SugarMilkCoffee(Coffee coffee) {
        super(new MilkCoffee(new SugarCoffee(coffee)));
    }

    @Override
    public String prepareCoffee() {
        return super.prepareCoffee();
    }

    @Override
    public double getCost() {
        return super.getCost();
    }
}
