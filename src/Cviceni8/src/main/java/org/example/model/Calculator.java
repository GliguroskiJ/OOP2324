package org.example.model;

public class Calculator {
    public int nasobeniAB (int a, int b)
    {
        if (a < 5) return (2*a*b);
        else if (a > 5 && a < 10) return (2*b)+a;
        else if (b == a) return a;
        else if (b > a) return -1000;
        else return 0;
    }
}
