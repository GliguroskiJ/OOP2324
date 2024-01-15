package org.facade;

public class Facade {
    private SubSystem1 systemOne;
    private SubSystem2 systemTwo;

    public Facade() {
        this.systemOne = new SubSystem1();
        this.systemTwo = new SubSystem2();
    }

    public void wrapper()
    {
        systemOne.methodOne();
        systemTwo.methodTwo();
    }

}
