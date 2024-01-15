package org.factory;

import javax.crypto.spec.PSource;

public class Cat implements Animal{
    @Override
    public void sound() {
        System.out.println("Mnau mnau");
    }
}
