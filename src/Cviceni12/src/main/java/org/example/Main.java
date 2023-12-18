package org.main;

import org.iterator.SimpleIterator;

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


    }
}