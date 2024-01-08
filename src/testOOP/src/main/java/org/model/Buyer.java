package org.model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private String name;
    private List<Goods> cart = new ArrayList<>();

    public Buyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Goods> getCart() {
        return cart;
    }

    public void addGood(Eshop eshop, Goods good, int quantity) {
        if (eshop.getStock(good) >= quantity ) {
            cart.add(new Goods(good.getName(), good.getPrice(), quantity));
            eshop.removeGood(good, quantity);
        }
        else System.out.println("Zboží nelze přidat do košíku, protože není na skladě");
    }

    public void emptyCart (Eshop eshop){
        for (int i = 0; i < cart.size(); i++){
            eshop.addGoodBack(cart.get(i), cart.get(i).getStock());
        }
        cart.clear();
    }
}
