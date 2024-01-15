package org.main;

import org.decorator.*;
import org.proxy.*;
import org.proxy2.*;
import org.facade.*;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void vypisKavy(Coffee coffee)
    {
        System.out.println(coffee.prepareCoffee());
        System.out.println(coffee.getCost());
    }
    public static String vratKavy(Coffee coffee)
    {
       return coffee.prepareCoffee()+"\n"+coffee.getCost()+"\n";
    }
    public static void main(String[] args) {

        Coffee simpleCoffee=new SimpleCoffee();
        vypisKavy(simpleCoffee);
        Coffee milkCoffee=new MilkCoffee(simpleCoffee);
        vypisKavy(milkCoffee);
        // TODO: create SugarCoffee
        // TODO: create MilkSugarCoffee
        Coffee sugarCoffee=new SugarCoffee(simpleCoffee);
        vypisKavy(sugarCoffee);
        Coffee milkSugarCoffee=new MilkCoffee(sugarCoffee);
        vypisKavy(milkSugarCoffee);
        List<Coffee> coffeList = new ArrayList<>();
        coffeList.add(simpleCoffee);
        coffeList.add(milkCoffee);
        coffeList.add(sugarCoffee);
        coffeList.add(milkSugarCoffee);
        for (Coffee coffee : coffeList) {
            System.out.printf("Z foreache: %s\n",vratKavy(coffee));
        }
        // Proxy
        Service s=new ServiceImpl();
        Service sproxy = new SimpleLoggingProxy(s);
        String output = sproxy.call("vstup");
        System.out.println(output);
        // Proxy 2
        Gate g=new GateReal();
        // Facade
        Facade f = new Facade();
        f.wrapper();

    }
}