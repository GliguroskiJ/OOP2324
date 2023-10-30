import java.util.Objects;
import java.util.Random;

public class Bojovnik {

    private String name;
    private int attack, defence, hp, intelligence;

    public Bojovnik (String name, int attack, int defence, int hp, int intelligence)
    {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.hp = hp;
        this.intelligence = intelligence;
    }
    private int rand(int min, int max)
    {
        Random rnd = new Random();
        return rnd.nextInt(min, max);
    }
    public int getAttack

}