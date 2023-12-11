package org.decorator;

public class SugarMilkCoffee extends CoffeeDecorator{
    public SugarMilkCoffee(Coffee coffee)
    {
        super(coffee);
    }

    @Override
    public String prepareCoffee()
    {
        return super.prepareCoffee()+", cukrem a s mlekem";
    }

    @Override
    public double getCost() {return super.getCost()};
}
