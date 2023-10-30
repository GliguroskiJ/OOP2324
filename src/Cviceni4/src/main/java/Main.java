public class Main {
    public static void main(String[] args)
    {
        Car car1 = new Car("modrá", 2015, 4);
        Car car2 = new Hyundai("zelená", 2023, 4, "diesel", 1250000);
        Hyundai car_hyundai1 = new Hyundai("červená", 2018, 4, "diesel");

        System.out.println(car1.returnColor());
        System.out.println(car2.returnColor());
        System.out.println(car_hyundai1.returnColor());

        car_hyundai1.sound();
        System.out.println(car_hyundai1.favouriteToy());

        System.out.println(car_hyundai1.returnS3());
        System.out.println(ExampleInt.returnS1());
    }
}
