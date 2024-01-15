package org.main;

import org.iterator.SimpleIterator;
import org.prototype.Car;
import org.strategy.BubbleSort;
import org.strategy.SelectionSort;
import org.strategy.Sorter;
import org.strategy.Sorting;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void printList(List<Integer> list){
        for(int i=0;i<list.size();i++){
            System.out.printf("%s,",list.get(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {

        String[] pismena =new String[]{"A","B","C","D"};
        SimpleIterator<String> it = new SimpleIterator<>(pismena);
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

        List<Integer> numbers = new ArrayList<Integer>(List.of(64, 25, 12, 22, 11,8,23,17));
        printList(numbers);
        // Strategy
        Sorter sorter = new Sorter( new BubbleSort());
        List<Integer> bubble= sorter.sortList(numbers);
        printList(bubble);
        sorter.setStrategy(new SelectionSort());
        List<Integer> selection= sorter.sortList(numbers);
        printList(selection);
        // Prototype
        Car auto0 = new Car("Skoda");
        System.out.println("Puvodni auto"+auto0.getName());
        try{
            Car auto1=(Car) auto0.clone();
            auto1.setName("BMW");
            System.out.println("Klonovane auto"+auto1.getName());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        System.out.println("Puvodni auto"+auto0.getName());

    }
}