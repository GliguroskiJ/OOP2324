package org.example;

import org.decorator.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void vypisKavy(Coffee coffee)
    {
        System.out.println(coffee.prepareCoffee());
        System.out.println(coffee.getCost());
    }
    public static void main(String[] args) {

        Coffee simpleCoffee=new SimpleCoffee();
        vypisKavy(simpleCoffee);

        Coffee milkCoffee=new MilkCoffee(simpleCoffee);
        vypisKavy(milkCoffee);

        Coffee sugarMilkCoffee=new SugarMilkCoffee(milkCoffee);
        vypisKavy(sugarMilkCoffee);
    }
}
