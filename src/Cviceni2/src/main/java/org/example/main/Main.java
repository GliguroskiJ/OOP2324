package org.example.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
/*
    // Funkce bez navratove hodnoty
    public static void vypis(String s)
    {
        System.out.println(s);
    }

    public static int pricti2(int a)
    {
        return a+=2;
    }

    public static int soucet(int a,int b)
    {
        return a+b;
    }

    public static int rozdil(int a,int b)
    {
        return a-b;
    }
    public static int soucin(int a,int b)
    {
        return a*b;
    }
    public static int podil(int a,int b)
    {
        return a/b;
    }

    public static int modulo(int a,int b)
    {
        return a%b;
    }

    public static void rekurze(int a)
    {
        if(a<=0)
        {
            return;
        }
        System.out.printf("%d",a);
        rekurze(a/2);
        rekurze(a/2);
    }
*/

    public static int[][] randomArray(int[] inputArr) {
        int[][] output = new int[inputArr.length][inputArr.length];
        //Recreate array with diagonale
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                if (i == j) {
                    output[i][j] = inputArr[i];
                } else {
                    output[i][j] = -1;
                }
            }
        }
        Random rndI = new Random();
        Random rndValue = new Random();
        int sum= Arrays.stream(inputArr).sum();
        int tmp=0;
        while(sum>0)
        {
            int i=rndI.nextInt(output.length);
            int j=rndI.nextInt(output.length);
            int val=rndValue.nextInt(output.length);
            while(val>9)
            {
                val=rndValue.nextInt(output.length);
            }
            if(output[i][j]<0 && i!=j && tmp<50000)
            {
                output[i][j]=val;
                sum-=val;
            }
            else if(i!=j && tmp>50000 && output[i][j]<output[i][j]+val)
            {
                output[i][j]+=val;
                sum-=val;
            }
            tmp+=1;
        }
        return output;
    }

    public static void vypis2D(int[][] arr2d)
    {
        for(int i=0;i<arr2d.length;i++)
        {
            for(int j=0;j<arr2d[i].length;j++)
            {
                System.out.printf(" %d ",arr2d[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] inputArr={1,4,8,9};
        //int[][] output=return_ar(inputArr);
        //vypis2D(output);


        // Staticke pole
        int[] arr={0,1,2,3,4};
        int[] arr2=new int[5];
        // 2D pole
        int[][] arr3=new int[5][5];
        // Listy dynamicke
        ArrayList<Integer> arrList=new ArrayList<>();

        // 2D list - prasarna, ale funkcni
        ArrayList<ArrayList<Integer>> arrList2d=new ArrayList<>();
        ArrayList<Integer> listOne=new ArrayList<>();
        arrList2d.add(listOne);

        arrList.add(6);
//        System.out.printf("%d, %d, %d",arr[0],arr2[0],arrList.get(0));
//import java.util.Random;
        Random rnd = new Random();
        int min=10;
        int max=20;
        int b= rnd.nextInt(max-min)+min;
        System.out.println("\n"+b);



        //rnd.nextInt(max-min)+min

        /*
        // vstup pro rekurzi=6
        int a=6;
        rekurze(a);

        vypis("Ahoj svete!");
        String s=String.format("Funkce mi vratila:%d",pricti2(5));
        vypis(s);
        */

/*
        int a=5;
        int b=4;
        int c=2;
        int res0=rozdil(soucin(a,c),b);
        int res1=podil(soucet(rozdil(a,b),c),soucet(c,soucin(b,a)));
        int res2=podil(rozdil(soucet(a,b),soucet(modulo(a,2),c)),
                rozdil(soucin(b,a),podil(rozdil(c,a),2)));

        System.out.printf("Vysledek prvniho je:%d\nVysledek druheho je:%d\nVysledek tretiho je:%d",res0,res1,res2);

*/
/*
        int r=10;
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<(int)r/2;j++)
            {
                if(i%2==0 && j%2==0)
                {
                    System.out.print("*");
                    continue;
                }
                else if(i%2==0)
                {
                    System.out.print("/");
                    continue;
                }
                String s=String.format("%d",(j+1-(int)r/2)*-1);
                System.out.print(s);
            }
            System.out.println();
        }
*/
/*
        for(int i=0;i<10;i++)
        {
            System.out.print("Ahoj tohle je"+i+"radek ");
        }


        int a=-1;
        do{
            System.out.println("A je vetsi nez 0, ver mi!");
        }while(a>0);
*/
        /*
        System.out.printf("Java is %d",a);
        double c=2.32332;
        System.out.printf("Java is %.2f",c);


/*
        int a=5;
        if(a>5)
        {
            System.out.println("A je vetsi nez 5");
        }
        else if (a<=5) {
            System.out.println("A je mensi rovno 5");
        }
        if(a==5)
        {
            System.out.println("A je rovno peti");
        }
        if(a<5)
        {
            System.out.println("A je opet mensi nez 5");
        }
        else if (a>=3)
        {
            System.out.println("A je vetsi rovno 3");
        }
           */

    }
}