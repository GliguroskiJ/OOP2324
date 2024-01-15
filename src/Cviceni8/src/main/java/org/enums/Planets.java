package org.enums;

public enum Planets {
    EARTH("Zeme",1),
    MARS("Mars",2);

    private final String name;
    private final int value;

    Planets(String name, int value)
    {
        this.name=name;
        this.value=value;
    }

    public String myMethod()
    {
        return String.format("Planeta: %s a cislo:%d",this.name, this.value);
    }

}
