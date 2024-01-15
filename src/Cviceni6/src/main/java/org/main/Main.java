package org.main;

import org.model.Animal;
import org.model.Box;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //List bez generiky před Java 5
        List list = new ArrayList<>();
        list.add("Ahoj");
        list.add(10);
        list.add(new Object());

        String str = (String) list.get(0); // vyžaduje přetypování

        List<Integer> list0= new ArrayList<>();
        list0.add(0);
        int v = list0.get(0);

        Box<Integer> box0= new Box<>();
        box0.set(5);
        System.out.printf("Datovy typ: %s a hodnota je: %d",box0.get().getClass().getSimpleName(),box0.get());

        Box<Animal> box1 = new Box<>();
        box1.set(new Animal("Svarta"));
        System.out.printf("Datovy typ: %s a hodnota je: %s",box1.get().getClass().getSimpleName(),box1.get());


    }
}