package org.main;

import org.AbstractFactory.BikeFactory;
import org.AbstractFactory.CarFactory;
import org.AbstractFactory.VehicleAssembler;
import org.AbstractFactory.VehicleFactory;
import org.factory.Animal;
import org.factory.AnimalFactory;
import org.factoryPolygon.Polygon;
import org.factoryPolygon.PolygonFactory;
import org.flyweight.Car;
import org.flyweight.CarType;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println(AnimalFactory.getAnimal("DOG"));
        Animal a = AnimalFactory.getAnimal("CAT");
        a.sound();

        Polygon p = PolygonFactory.createPolygon(3);
        System.out.println(p.whatamI());
        System.out.println(p.getSides());

        VehicleFactory factory = new CarFactory(); // nebo BikeFactory
        VehicleFactory bikefactory= new BikeFactory();
        VehicleAssembler assembler = new VehicleAssembler(factory);
        assembler.assemble();

        //Flyweight
        CarType medour = new CarType("Medour","1000","4");
        Car c0=new Car(medour,"oranzova");
        Car c1=new Car(medour,"modry");
        System.out.println(c1.getType().getNumberOfWheels());
    }
}