package org.cv.main;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import org.cv.model.Factory;
import org.cv.model.Patient;

public class Main {
    public static void getPatientByID(int id, Object[] patientList) {
        String output="";
        for (Object obj:patientList
             ) {
            if ( obj instanceof String[])
            {
                Object[] array=(Object[]) obj;
                output+=" "+array[id];
            }
            else if ( obj instanceof  int[])
            {
                int[] array=(int[]) obj;
                output+=" "+array[id];
            }
        }
        System.out.println(output);
    }

    public static void main(String[] args) {

//        String[] name={"Pavel","Tomas","Karel"};
//        String[] surname={"Jedno","Velky","Maly"};
//        int[] year={1012,2392,2022};
//
//        Object[] patientList= new Object[3];
//        patientList[0]=name;
//        patientList[1]=surname;
//        patientList[2]=year;
//        getPatientByID(1,patientList);
//
//        Patient p1 = new Patient("Tomas","Marny",1999);
//        Patient p2 = new Patient("Tomas","Jedno",1987);
//        Patient p3 = new Patient("Tomas","Jedno",1987);
//        System.out.println(p2.hashCode());
//        System.out.println(p3.hashCode());
//        System.out.println(p2.equals(p3));
//
//        System.out.println(p1.toString());
//        System.out.println(p2.toString());

        Factory f1 = new Factory(1020);
        f1.createCar("medour","rychly","oranzove");
        System.out.println(f1.toString());

        }


}
