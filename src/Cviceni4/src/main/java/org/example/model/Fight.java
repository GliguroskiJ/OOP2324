package org.example.model;

public class Fight {

    private Fighter f1;
    private Fighter f2;

    public Fighter winner;

    public Fight(Fighter f1, Fighter f2) {
        this.f1 = f1;
        this.f2 = f2;
        winner=this.simulate();
    }

    public Fighter simulate()
    {
        while(f1.getHp()>0 && f2.getHp()>0)
        {
            int f1Int=f1.genInt();
            int f2Int=f2.genInt();
            if (f1Int>f2Int)
            {
                attackRound(f1,f2);
            }
            else
            {
                attackRound(f2,f1);
            }
        }
        if(f1.getHp()>0)
        {
            return f1;
        }
        return f2;
    }

    public void attackRound(Fighter f1,Fighter f2)
    {
        int atk = f1.genAttack();
        int deff = f2.genDeff();
        if(deff>=atk)
        {
            System.out.printf("Bojovnik: %s se uspesn2 ubranil utoku.\n",f2.getName());
        }
        else
        {
            f2.changeHP(deff-atk);
            System.out.printf("Bojovnik: %s zautocil na bojovnika: %s silou %d a branicimu" +
                    "bojovnikovi ted zbyva: %d zivotu\n",f1.getName(),f2.getName(),(deff-atk)*-1,f2.getHp());
        }
    }

    public Fighter getF1() {
        return f1;
    }

    public Fighter getF2() {
        return f2;
    }

    @Override
    public String toString() {
        return "Fight{" +
                "f1=" + f1 +
                ", f2=" + f2 +
                '}';
    }
}
