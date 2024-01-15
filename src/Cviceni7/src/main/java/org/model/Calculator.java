package org.model;

public class Calculator {

    // Vytvorte si metodu pro nasobeni
    public int multiply(int a, int b)
    {
        return a*b;
    }

    public int multiply2(int a, int b)
    {
        if (a<5)
        {return 2*a*b;}
        else if (a>5 && a<10) {
            return 2*b+a;
        }
        else if (b==a)
            return a;
        else if(b>a)
            return -1000;
        else
            return 0;

    }

    public boolean isEven(int a)
    {
        return a%2==0;
    }

}
