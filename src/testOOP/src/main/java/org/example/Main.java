package org.example;

import org.model.Buyer;
import org.model.Eshop;
import org.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Eshop eshop = new Eshop("Elektronika");

        Goods Z1 = new Goods("Notebook", 15000, 3);
        Goods Z2 = new Goods("Monitor", 4300, 2);
        Goods Z3 = new Goods("Klávesnice", 1000, 6);
        Goods Z4 = new Goods("Složené PC", 20000, 1);
        Goods Z5 = new Goods("Myš", 500, 0);

        eshop.addGood(Z1);
        eshop.addGood(Z2);
        eshop.addGood(Z3);
        eshop.addGood(Z4);
        eshop.addGood(Z5);

        System.out.println("E-shop Elektronika:");
        for (int i = 0; i < eshop.getPrintStock().size(); i++){
            System.out.println("Zboží "+eshop.getPrintStock().get(i).getName()+" s cenou "+eshop.getPrintStock().get(i).getPrice()+"Kč je na skladě "+eshop.getPrintStock().get(i).getStock()+"x.");
        }

        Buyer B1 = new Buyer("Petr Novotný");
        Buyer B2 = new Buyer("Lukáš Malý");
        Buyer B3 = new Buyer("Marek Oblý");

        eshop.addBuyer(B1);
        eshop.addBuyer(B2);
        eshop.addBuyer(B3);

        B1.addGood(eshop, Z1, 2);
        B2.addGood(eshop, Z1, 1);
        B2.emptyCart(eshop);
        B1.addGood(eshop, Z1, 1); //stale vidi ze nemuze pridat ale zbozi by melo byt vracene po emptycart u B2
    }
}