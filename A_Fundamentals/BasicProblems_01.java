package A_Fundamentals;

import java.util.Scanner;

public class BasicProblems_01 {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        //04 - area and perimeter of the rectangle

        /* System.out.println("enter length of rectangle");
        double length = input.nextDouble();

        System.out.println("enter width of rectangle");
        double width = input.nextDouble();

        System.out.println("area of rectangle is :" + (length * width));

        System.out.println("perimeter of rectangle is :" + 2*(length + width)); */



        //05 - area and circumference of circle

        /* double radius = 3;

        double area = Math.PI * radius * radius;

        System.out.println("area of circle is :" + area);

        double diameter = 2 * radius;

        double circumference = Math.PI * diameter;

        System.out.println("circumference of circle :" + circumference); */


        
        //06 - calculating total mechanical energy

        /* System.out.println("enter the value of mass");
        double mass = input.nextDouble();

        System.out.println("enter the value of velocity");
        double velocity = input.nextDouble();

        double ke = 0.5 * mass * Math.pow(velocity, 2);

        System.out.println("kinetic energy is :" + ke);

        double gravity = 9.8;

        System.out.println("enter the value of height");
        double height = input.nextDouble();
        
        double pe = mass * gravity * height;

        System.out.println("potential energy is :" + pe);

        //total mechanical energy 
        double tme = ke + pe;

        System.out.println("total mechanical energy is :" + tme); */



        //07 - Volume of Cylinder

        /* System.out.println("enter the height of cylinder");
        double height = input.nextDouble();

        System.out.println("enter the radius of cylinder");
        double radius = input.nextDouble();

        double volume = Math.PI * radius * radius * height;

        System.out.println("volume of cylinder is :" + volume); */



        //08 - Temperature conversion

        /* System.out.println("enter the temperature in fahrenheit");
        double f = input.nextDouble();

        double c = (f - 32) * (5.0 / 9.0);

        System.out.println("temperature in celcius is :" + c + " " + "C"); */


        
        //09 - two numbers swapping using temporary variable

        /*
        int a = 4;
        int b = 5;
        
        //swapping
        int temp = a;
        a = b;
        b = temp;
        
        System.out.println("a value is :" + a + " " + "b values is :" + b); */



        //10 - swap without using temp

        /* 
        int a = 5;
        int b = 6;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a value is :" + a + " " + "b value is :" + b); */



        //11-swapping in single line

        /* int a = 5;
        int b = 9;

        b = a + b - (a = b); //

        System.out.println(a + " " + b); */



        //12- marks of three subjects ,find total and average.

        System.out.println("enter english marks");
        int english = input.nextInt();

        System.out.println("enter science marks");
        int science = input.nextInt();

        System.out.println("enter math marks");
        int math = input.nextInt();

        int total = english + science + math;
        int avg = total/3;

        System.out.println("total marks is :" + total);
        System.out.println("average marks is :" + avg); 

        
        input.close();
    }
}
