public class Car {
    protected String color;
    protected int year;
    protected int numberOfWheels;

    public Car(String color, int year, int numberOfWheels)
    {
        this.color = color;
        this.year = year;
        this.numberOfWheels = numberOfWheels;
    }

    public String returnColor()
    {
        return String.format("Auto je barvy: %s", this.color);
    }
}
