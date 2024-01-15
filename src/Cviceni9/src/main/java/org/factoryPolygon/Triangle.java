package org.factoryPolygon;

public class Triangle implements Polygon{

    private final int sides;
    public Triangle()
    {
        sides=3;
    }
    @Override
    public String whatamI() {
        return "Jsem Trojuhelnik";
    }

    @Override
    public int getSides()
    {
        return this.sides;
    }
}
