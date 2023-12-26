package org.example;

import org.Strategy.BubbleSort;
import org.Strategy.Sorter;
import org.iterator.SimpleIterator;
import org.prototype.Car;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String[] pismena =new String[]{"A","B","C","D"};
        SimpleIterator<String> it = new SimpleIterator<>(pismena);
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        List<Integer> numbers = List.of(64, 25, 12, 22, 11,8,23,17);

        Sorter bubbleSort = new Sorter (new BubbleSort());

        Car auto0 = new Car("Skoda");
        System.out.println("Puvodní auto"+auto0.getNazev());

    }
}