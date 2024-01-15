package org.strategy;

import java.util.List;

public class Sorter {
    private Sorting strategy;

    public Sorter(Sorting strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public List<Integer> sortList(List<Integer> list) {
        return strategy.sort(list);
    }
}
