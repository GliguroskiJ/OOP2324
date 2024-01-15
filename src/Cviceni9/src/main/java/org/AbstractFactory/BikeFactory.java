package org.AbstractFactory;

public class BikeFactory implements VehicleFactory{

    @Override
    public Engine createEngine() {
        return new BikeEngine();
    }

    @Override
    public Wheel createWheel() {
        return new BikeWheel();
    }
}
