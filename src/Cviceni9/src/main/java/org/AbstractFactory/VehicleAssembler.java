package org.AbstractFactory;

public class VehicleAssembler {
    private Engine engine;
    private Wheel wheel;

    public VehicleAssembler(VehicleFactory factory) {
        engine = factory.createEngine();
        wheel = factory.createWheel();
    }

    public void assemble() {
        System.out.printf("Motor:%s, kolo:%s\n",engine.sound(),wheel.material());
        System.out.println("Vehicle assembled.");
    }

}
