package org.main;

import org.model.Car;
import org.model.CarAsBuilder;
import org.model.Dog;
import org.model.Hyundai;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Car c0=new Car("hneda",2020,5);
        Car c1 = new Hyundai("cervena",2010,3,10000,"Rychly");
        Hyundai h0 = new Hyundai("cerna",2011,2,"Mega rychly");
        System.out.println(c1.example());

        System.out.println(c0.toString());
        System.out.println(c1.toString());
        System.out.println(h0.toString());

        System.out.println(h0.getPrice());

        // Interfaces
        Dog d0= new Dog();
        System.out.println(d0.sound());
        d0.favouriteToy();

        // Interfaces 2
        System.out.println(d0.returnSomething3());
        System.out.println(d0.returnSomething());





        CarAsBuilder car = new CarAsBuilder.Builder()
                .setColor("Red")
                .setPrice(25000)
                .setBrand("Toyota")
                .setEngineType("Gasoline")
                .build();
        System.out.println(car.toString());
    }
}