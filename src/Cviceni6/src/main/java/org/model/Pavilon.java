package org.model;

import java.util.List;

public class Pavilon {

    List<Animal> animalList;
    Breeder breeder;

    public Pavilon()
    {

    }

    public void addAnimal(Animal animal)
    {
        animalList.add(animal);
    }

    public void setBreeder(Breeder breeder)
    {
        this.breeder=breeder;
    }
}
