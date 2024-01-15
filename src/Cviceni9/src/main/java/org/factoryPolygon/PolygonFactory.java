package org.factoryPolygon;

public class PolygonFactory {
    public static Polygon createPolygon(int numSides) {
        if (numSides == 3) {
            return new Triangle();
        } else if (numSides == 4) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("cannot handle numSides: " + numSides);
        }
    }
}
