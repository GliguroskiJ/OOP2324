public class Hyundai extends Car implements BehavioralPattern, ExampleInt
{
    protected String motor;
    protected int price;

    public Hyundai(String color, int year, int numberOfWheels, String motor, int price) {
        super(color, year, numberOfWheels);
        this.motor = motor;
        this.price = price;
    }

    public Hyundai(String color, int year, int numberOfWheels, String motor) {
        super(color, year, numberOfWheels);
        this.motor = motor;
    }

    public String favouriteToy()
    {
       return "klíče";
    }

    public void sound()
    {
        System.out.println("Auto dělá vrum vrum");
    }

    @Override
    public String returnColor()
    {
        return String.format("Auto je ze tridy Hyundai barvy: %s", this.color);
    }
}
