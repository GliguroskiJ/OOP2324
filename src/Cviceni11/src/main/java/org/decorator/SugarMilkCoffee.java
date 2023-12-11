package org.decorator;

public class SugarMilkCoffee extends CoffeeDecorator{
    public SugarMilkCoffee(Coffee coffee)
    {
        super(coffee);
    }

    @Override
    public String prepareCoffee()
    {
        return super.prepareCoffee()+" a cukrem";
    }

    @Override
    public double getCost() {return super.getCost()+6;}
}
