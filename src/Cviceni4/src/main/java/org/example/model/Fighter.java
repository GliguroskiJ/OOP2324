package org.example.model;

import java.util.Objects;
import java.util.Random;

public class Fighter {
    private String name;
    private int atk;
    private int deff;
    private int hp;
    private int intel;

    public Fighter(String name, int atk, int deff, int hp, int intel) {
        this.name = name;
        this.atk = atk;
        this.deff = deff;
        this.hp = hp;
        this.intel = intel;
    }

    private int genRandom(int min, int max)
    {
        Random rnd= new Random();
        return rnd.nextInt(max-min)+min;
    }

    public int genAttack()
    {
        return genRandom(atk/2,atk);
    }

    public int genDeff()
    {
        return genRandom(1,deff);
    }

    public int genInt()
    {
        return genRandom(intel/2,intel+intel/4);
    }

    public void changeHP(int val)
    {hp+=val;}

    public String getName()
    {
        return this.name;
    }
    public int getHp() {
        return hp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighter = (Fighter) o;
        return atk == fighter.atk && deff == fighter.deff && hp == fighter.hp && intel == fighter.intel && Objects.equals(name, fighter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, atk, deff, hp, intel);
    }

    @Override
    public String toString() {
        return String.format("Bojovnik jmenem: %s silou: %d defenzivou:" +
                " %d a inteligenci %d",name,atk,deff,intel);
    }
}
