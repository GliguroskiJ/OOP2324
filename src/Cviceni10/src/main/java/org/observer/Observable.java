package org.observer;

public interface Observable {
    void register(Customer customer);
    void unregister(Customer customer);
}
