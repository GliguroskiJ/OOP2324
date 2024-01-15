package org.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer implements Observer, Observable{

    private int id;
    private Set<Customer> customerList= new HashSet<>();
    private List<String> calls = new ArrayList<>();

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void register(Customer customer) {
        this.customerList.add(customer);
    }

    @Override
    public void unregister(Customer customer) {
        this.customerList.remove(customer);
    }

    @Override
    public void update(String text) {
        for(Customer customer:customerList)
        {
            String t="Customer "+customer.getId()+" has been notified";
            calls.add(t);
            customer.update(t);
            System.out.println(t);
        }
    }
}
