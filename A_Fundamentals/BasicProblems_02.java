package A_Fundamentals;

import java.util.Scanner;

public class BasicProblems_02 {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        //13 - milk vendor buys milk at price 20 per litre, he adds 1 litre of water for every 4 litre of milk.
        //     he sells at rate of 25rs. print the gain by taking number of litres he bought.

        /*  System.out.println("enter the no of litres of milk, vendor bought");
        float litresBuy = input.nextFloat();

        float totalLitres = litresBuy + (litresBuy/4);

        System.out.println("total budget he spent is :" + litresBuy * 20);

        System.out.println("total sale :" + totalLitres * 25);

        System.out.println("profit gain is :" + ((totalLitres * 25) - (litresBuy * 20))); */



        //14 - input a single digit number(n) then create a three digit number as like n n+1 n+2

        /* System.out.println("enter a number which is in range 1 - 7");
        int num1 = input.nextInt();
        int num2 = num1 + 1;
        int num3 = num1 + 2;

        // String output = num1 + "" + num2 + "" + num3;
        if(num1 <= 7){
            int output = (num1*100) + (num2 * 10) + num3;
            System.out.println(output);
        }else{
            System.out.println("not a valid number");
        } */



        //15 - take three inputs and swap first two variables with sums of first and second, second and third.

        /* System.out.println("enter first number");
        int first = input.nextInt();

        System.out.println("enter second number");
        int second = input.nextInt();

        System.out.println("enter third number");
        int third = input.nextInt();

        first = first + second;

        second = second + third;

        System.out.println("first = " + first + " secoond = " + second + " third = " + third); */



        //16 - take input as basic salary of employ , and find DA(10 percent) ,HRA (20), pf(5)

        System.out.println("enter the basic salary");
        double salary = input.nextDouble();
        double DA = (salary * 10) / 100;

        double HRA = (salary * 20) / 100;

        double PF = (salary * 5) / 100;

        double totalSalary = salary + DA + HRA - PF;

        // System.out.println("total salary is :" + totalSalary);
        System.out.printf("total salary is : %.3f%n", totalSalary);
        
    }

}
