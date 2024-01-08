package org.model;

import java.util.ArrayList;
import java.util.List;

public class Eshop {
    private List<Goods> stock = new ArrayList<>();
    private List<Buyer> registeredUsers = new ArrayList<>();
    private String name;

    public Eshop(String name) {
        this.name = name;
    }

    public List<Goods> getPrintStock() {
        return stock;
    }

    public int getStock(Goods good){
        Goods selectedGood = good;
        int selectedStock = 0;
        for (int i = 0; i < stock.size(); i++){
            if (stock.get(i) == selectedGood){
                selectedStock = stock.get(i).getStock();
            }
        }
        return selectedStock;
    }

    public List<Buyer> getRegisteredUsers() {
        return registeredUsers;
    }

    public void addBuyer (Buyer buyer) {
        registeredUsers.add(buyer);
    }

    public void addGood (Goods good) {
        stock.add(good);
    }

    public void addGoodBack (Goods good, int quantity) {
        for (int i = 0; i < stock.size(); i++){
            if (stock.get(i) == good){
                stock.get(i).setStock(stock.get(i).getStock()+quantity);
            }
            //notify
        }
    }

    public void removeGood (Goods good, int quantity){
        Goods selectedGood = good;
        int selectedStock = 0;
        for (int i = 0; i < stock.size(); i++){
            if (stock.get(i) == selectedGood){
                stock.get(i).setStock(stock.get(i).getStock()-quantity);
            }
        }
    }
}
