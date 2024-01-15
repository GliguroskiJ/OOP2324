package org.AbstractFactory;

public class CarEngine implements Engine{
    @Override
    public String sound() {
        return "Vrum vrum";
    }
}
