public interface ExampleInt {
    static String returnS1()
    {
        return "Hello world";
    }
    private String returnS2()
    {
        return "Ahoj svete";
    }
    default String returnS3()
    {
        return "Ahoj";
    }
}
