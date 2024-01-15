package org.flyweight;

public class CarType {
    private String type;
    private String weight;
    private String numberOfWheels;

    public CarType(String type, String weight, String numberOfWheels) {
        this.type = type;
        this.weight = weight;
        this.numberOfWheels = numberOfWheels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(String numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
