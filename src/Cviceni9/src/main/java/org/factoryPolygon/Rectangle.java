package org.factoryPolygon;

public class Rectangle implements Polygon{

    private final int sides;

    public Rectangle()
    {
        this.sides=3;
    }

    @Override
    public String whatamI() {
        return "Ja jsem ctverec nebo obdelnicek";
    }

    @Override
    public int getSides()
    {
        return this.sides;
    }
}
