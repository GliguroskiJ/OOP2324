package org.AbstractFactory;

public class BikeEngine  implements Engine{
    @Override
    public String sound() {
        return "Brm brm";
    }
}
