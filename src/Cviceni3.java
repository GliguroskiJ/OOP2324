import java.util.Scanner;
public class Cviceni3 {
    static Scanner scanner = new Scanner(System.in);
    static int prvniCislo, druheCislo;
    static String spojeniSlov(String prvniSlovo, String druheSlovo)
    {
        return prvniSlovo+" "+druheSlovo;
    }
    public static void main(String[] args)
    {
        String finalSlovo = spojeniSlov("Hello","world");
        System.out.println(finalSlovo);

        System.out.print("Zadejte prvni cislo: ");
        try { prvniCislo = scanner.nextInt(); }
        catch(Exception e){ System.out.println("Zadavat můžeš pouze čísla!");}

        System.out.print("Zadejte druhe cislo: ");
        try { druheCislo = scanner.nextInt(); }
        catch(Exception e){ System.out.println("Zadavat můžeš pouze čísla!");}

        int soucet = prvniCislo + druheCislo;
        System.out.print("Vysledek: "+soucet);
    }
}
