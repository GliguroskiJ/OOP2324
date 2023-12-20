package org.Strategy;
import org.Strategy.*;
import org.strategy.Sorting;

import java.util.List;

public class Sorter {
    private Sorting strategy;

    public Sorter(Sorting strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public List<Integer> sortList(List<Integer>) {
        return null;
    }
}
