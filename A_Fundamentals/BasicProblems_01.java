package A_Fundamentals;

import java.util.Scanner;

public class BasicProblems_01 {
    public static void main(String args[]){
        
        //09 - two numbers swapping using temporary variable

        /*
        int a = 4;
        int b = 5;
        
        //swapping
        int temp = a;
        a = b;
        b = temp;
        
        System.out.println("a value is :" + a + " " + "b values is :" + b);
        */

        //10 - swap without using temp

        /* 
        int a = 5;
        int b = 6;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a value is :" + a + " " + "b value is :" + b);
        */

        //11-swapping in single line

        /* int a = 5;
        int b = 9;

        b = a + b - (a = b); //

        System.out.println(a + " " + b); */

        //12- marks of three subjects ,find total and average.

        /* Scanner input = new Scanner(System.in);

        System.out.println("enter english marks");
        int english = input.nextInt();

        System.out.println("enter science marks");
        int science = input.nextInt();

        System.out.println("enter math marks");
        int math = input.nextInt();

        int total = english + science + math;
        int avg = total/3;

        System.out.println("total marks is :" + total);
        System.out.println("average marks is :" + avg); */
    }
}
