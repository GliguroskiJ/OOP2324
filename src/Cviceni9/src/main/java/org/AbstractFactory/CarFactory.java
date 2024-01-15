package org.AbstractFactory;

public class CarFactory implements VehicleFactory{

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

    @Override
    public Wheel createWheel() {
        return new CarWheel();
    }
}
