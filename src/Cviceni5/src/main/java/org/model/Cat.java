package org.model;

public class Cat implements BehavioralPattern{

    public Cat() {
    }

    @Override
    public String sound() {
        return "Cauky mnauky";
    }

    @Override
    public void favouriteToy() {
        System.out.println("Panickove");
    }
}
