package org.example.main;


import org.example.model.Dog;
import org.example.model.Fight;
import org.example.model.Fighter;
import org.example.model.MyExceptionClass;

import java.security.KeyException;
import java.time.temporal.ValueRange;

public class Main {
    public static void main(String[] args) {

    Dog d0= new Dog("Maxik",7,"zlaty retivr");
    System.out.println(d0.toString());
    d0.sound();
    Fighter f0= new Fighter("Karel",20,10,150,10);
    Fighter f1= new Fighter("Svarta", 15, 12,200,7);
    Fight f = new Fight(f0,f1);
    System.out.println(f.winner);
//        // Vyjimky example
//        int[] a={0,1,2};
//
//        try{
//            System.out.println(a[8]);
//        }
//        catch(Exception e)
//        {
//            System.out.println("Chyba, odkazujeme na neexistujici prvek");
//        }
//
//        try{
//            if(a[0]==0)
//            {
////                throw new KeyException("Priklad vyjimky");
//                throw new MyExceptionClass("Priklad3");
//            }
//        }
//        catch( MyExceptionClass e)
//        {
//            System.out.printf("Koukni jak to jde, hlaska byla %s",e);
//        }



    }
}