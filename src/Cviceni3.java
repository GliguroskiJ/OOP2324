
public class Cviceni3 {
    static String spojeniSlov(String prvniSlovo, String druheSlovo)
    {
        return prvniSlovo+" "+druheSlovo;
    }
    public static void main(String[] args)
    {
        String finalSlovo = spojeniSlov("Hello","world");
        System.out.print(finalSlovo);
    }
}
