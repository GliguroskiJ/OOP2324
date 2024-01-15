package org.example.model;

public class Dog extends Animal implements AnimalInt{

    private String race;
    public Dog(String name, int age,String race)
    {
        super(name,age);
        this.race=race;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "race='" + race + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void sound() {
        System.out.println("Haf haf.");
    }
}
