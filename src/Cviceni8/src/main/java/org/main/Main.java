package org.main;

import org.enums.Days;
import org.enums.Planets;
import org.models.Patient;
import org.models.Person;

import java.util.HashSet;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//        System.out.println(Days.MONDAY);
        String s0 = Days.MONDAY.name();
        String s1 = Days.TUESDAY.toString();

        System.out.printf("Prvni je %s, Druhy je %s\n",s0,s1);

        System.out.println(Planets.EARTH.myMethod());

        Set<String> stringSet= new HashSet<>();
        stringSet.add("Jedna");
        stringSet.add("Dva");
        stringSet.add("Jedna");
        for (String s:stringSet)
        {
            // Vypsat vsechny stringy.
            System.out.println(s);
        }

        Set<Patient> pacientSet = new HashSet<>();
        Patient pac = new Patient(0,"Tomas","Jedno");
        pacientSet.add(pac);
        pacientSet.add(new Patient(1,"Tomas","Marny"));
        pacientSet.add(new Patient(2,"Tomas","Fuk"));

        for(Patient p:pacientSet)
        {
//            System.out.println(p.toString());
            if(p.equals(pac))
            {
                System.out.printf("Toto je totozny pacos %s\n",p.toString());
                continue;
            }
            System.out.printf("Toto je unikatni pacos %s\n",p.toString());
        }

        Person p = new Person.PersonBuilder()
                .setBirthNumber(321073012)
                .setFirstName("Prokop")
                .setLastName("Buben")
                .build();
        System.out.printf("Dat. typ je: %s a je v nem hodnota:\n%s\n",p.getClass(),p.toString());


    }
}