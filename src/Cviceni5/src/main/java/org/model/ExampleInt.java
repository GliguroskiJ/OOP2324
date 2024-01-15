package org.model;

public interface ExampleInt {

    static String returnSomething()
    {
//        return String.format("\n%s\n%s\n","Hello World",returnSomething2());
        return "HEllo world.";
    }

    private String returnSomething2()
    {
        return "Ahoj svete";
    }

    default String returnSomething3()
    {
        return "Ahoj";
    }

}
