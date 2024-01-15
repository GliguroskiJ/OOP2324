package org.AbstractFactory;

public interface VehicleFactory {
    Engine createEngine();
    Wheel createWheel();
}
