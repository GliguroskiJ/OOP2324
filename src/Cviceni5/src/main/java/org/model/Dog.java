package org.model;

public class Dog implements BehavioralPattern, ExampleInt{

    public Dog() {
    }

    @Override
    public String sound() {
        return "haf Haf";
    }

    @Override
    public void favouriteToy() {
        System.out.println("Míček");
    }

    @Override
    public String returnSomething3()
    {
        return "Od Psika";
    }

    public String returnSomething()
    {
        return ExampleInt.returnSomething();
    }

    // Nejde protoze je private
//    public String returnSomething2()
//    {
//        return ExampleInt.returnSomething2();
//    }
}
