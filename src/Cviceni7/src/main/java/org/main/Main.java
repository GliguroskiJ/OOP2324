package org.main;

import org.model.Singleton;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Singleton sin= Singleton.getInstance("Prvni");
        System.out.println(sin.value);
        Singleton sin2 = Singleton.getInstance("druhy");
        System.out.println(sin2.value);

    }
}