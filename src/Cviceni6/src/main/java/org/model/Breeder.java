package org.model;

public class Breeder extends Employee{

    private int pavilonID=0;
    public Breeder(String name, String surname) {
        super(name, surname);
    }
    public Breeder(String name, String surname, int id) {
        super(name, surname);
        pavilonID=id;
    }

    public void setPavilonID(int id)
    {
        this.pavilonID=id;
    }

}
