package A_Fundamentals;

import java.util.Scanner;

public class BasicProblems {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        /* System.out.println("enter a vowel");
        char ch = input.next().charAt(0);
        
        if(ch == 'a') System.out.println("vowel");
        else if(ch == 'e') System.out.println("vowel");
        else if(ch == 'i') System.out.println("vowel");
        else if(ch == 'o') System.out.println("vowel");
        else if(ch == 'u') System.out.println("vowel");
        else if(ch == 'A') System.out.println("vowel");
        else if(ch == 'E') System.out.println("vowel");
        else if(ch == 'I') System.out.println("vowel");
        else if(ch == 'O') System.out.println("vowel");
        else if(ch == 'U') System.out.println("vowel");
        else System.out.println("not a vowel"); */

        /* if(Character.toLowerCase(ch) == 'a' || Character.toLowerCase(ch) == 'e' || Character.toLowerCase(ch) == 'i' 
                || Character.toLowerCase(ch) == 'o' || Character.toLowerCase(ch) == 'u'){
            System.out.println("vowel");
        }else{
            System.out.println("not a vowel");
        } */

        //biggest of 3 numbers using nested if 

        /* 
        System.out.println("enter first number");
        int a = input.nextInt();
        System.out.println("enter second number");
        int b = input.nextInt();
        System.out.println("enter third number");
        int c = input.nextInt();
        System.out.println("enter fourth number");
        int d = input.nextInt();

        if(a > b){
            if(a > c){
                if(a > d){
                    System.out.println("a is big :" + a);
                }else{
                    System.out.println("d is big :" + d);
                }
            }else{
                if(c > d){
                    System.out.println("c is big :" + c);
                }else{
                    System.out.println("d is big :" + d);
                }
            }
        }else{
            if(b > c){
                if(b > d){
                    System.out.println("b is big :" + b);
                }else{
                    System.out.println("d is big :" + d);
                }
            }else{
                if(c > d){
                    System.out.println("c is big :" + c);
                }else{
                    System.out.println("d is big :" + d);
                }
            }
        }  */

        /* if(a > b){ 
            a = a;
        }else{
            a = b;
        }

        if(c > d){ 
            c = c;
        }else{
            c = d;
        }

        System.out.println("big number is :" + ((a > c) ? a : c)); */

        //Student pass or fail

        /* System.out.println("enter subject1 marks");
        int s1 = input.nextInt();

        System.out.println("enter subject2 marks");
        int s2 = input.nextInt();

        System.out.println("enter subject3 marks");
        int s3 = input.nextInt();

        if(s1 < 35 || s2 < 35 || s3 < 35){
            System.out.println("Student failed the examination");
        }else{
            System.out.println("Student passed the examination");
        } */

        //traingle or not by using degree
        
        /* System.out.println("enter the angle 1");
        int angle1 = input.nextInt();

        System.out.println("enter the angle 2");
        int angle2 = input.nextInt();

        System.out.println("enter the angle 3");
        int angle3 = input.nextInt();

        if((angle1 + angle2 + angle3) != 180){
            System.out.println("traingle cannot be formed");
        }else{
            if(angle1 == angle2 && angle2 == angle3){
            System.out.println("it is equilateral traingle");
            }

            if(angle1 < 90 || angle2 < 90 || angle3 < 90){
                System.out.println("it is acute traingle");
            }

            if(angle1 == 90 || angle2 == 90 || angle3 == 90){
                System.out.println("it is right angle traingle");
            }

            if(angle1 > 90 || angle2 > 90 || angle3 > 90){
                System.out.println("it is obtuse angle traingle");
            }
        } */


        
        //vowel or not sing switch

        /* System.out.println("enter a character");
        char ch = input.next().charAt(0);

        switch(Character.toLowerCase(ch)){
            case 'a' , 'e' , 'i' , 'o' , 'u' : System.out.println("vowel"); break;
            default : System.out.println("not a vowel");
        } */

        // System.out.println("enter a number within range 1 -7");
        // int num = input.nextInt();

        // switch(num){
        //     case 1 : System.out.println("monday"); break;
        //     case 2 : System.out.println("tuesday"); break;
        //     case 3 : System.out.println("wednessday"); break;
        //     case 4 : System.out.println("thursday"); break;
        //     case 5 : System.out.println("friday"); break;
        //     case 6 : System.out.println("saturday"); break;
        //     case 7 : System.out.println("sunday"); break;
        //     default : System.out.println("Invalid");
        // }

        // System.out.println("enter a year");
        // int year = input.nextInt();

        // if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
        //     System.out.println("leap year");
        // }else{
        //     System.out.println("not a leap year");
        // }


        // if(year % 400 == 0){
        //     System.out.println("leap year");
        // }else if(year % 4 == 0){
        //     if(year % 100 != 0){
        //         System.out.println("leap year");
        //     }
        //     System.out.println("not a leap year");
        // }else{
        //     System.out.println("not a leap year");
        // }

        /* System.out.println("enter a month");
        int month = input.nextInt();

        System.out.println("enter a year");
        int year = input.nextInt();

        boolean leapYear = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
        boolean days30 = month == 4 || month == 6 || month == 9 || month == 11;
        boolean days31 = month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12;

        if(month <= 12 && month >= 0){
            if(leapYear && month == 2){
                System.out.println("it has 29 days");
            }
            if(!leapYear && month == 2){
                System.out.println("it has 28 days");
            }
            if(days30){
                System.out.println("it has 30 days");
            }
            if(days31){
                System.out.println("it has 31 days");
            }
        }else{
            System.out.println("invalid month");
        } */
       

        //converting small char
        /* System.out.println("enter a character");
        char ch = input.next().charAt(0);

        if('a' - ch >= 7 && 'a' - ch <=32){
            System.out.println(Character.toLowerCase(ch));
        }else if('a' - ch <= 0 && 'a' - ch >= -25){
            System.out.println(Character.toUpperCase(ch));
        }else{
            System.out.println("invalid");
        } */

        //increment model
        /* int i = 1;
        while(i <= 5){
            System.out.println("sriram");
            i++;
        }
        System.out.println("while loop closed");

        //decrement model
        int j = 5;
        while(j >= 1);{
            System.out.println("sriram");
            j--;
        }
        System.out.println("while loop closed"); */

        /* int counter = 1;
        for( ; counter <= 5 ;){   //boolean expression is mandatory.
            System.out.println("sriram");
            counter++;
        } */

        /* int i = 4;
        do{
            System.out.println("sriram");
            ++i;
        }
        while(i <= 5); */

        //parking time and charges

        /* System.out.println("enter the start time");
        double inTime = input.nextDouble();

        System.out.println("enter the end time");
        double outTime = input.nextDouble();

        double diff = outTime - inTime;

        if(diff < 0){
            diff = diff + 24;
        } */

        // if(diff < 24 && diff >= 0){
        //     if(diff < 3){
        //         System.out.println("10 rs charged");
        //     }else if(diff >= 3 && diff < 6){
        //         System.out.println("15 rs charged");
        //     }else if(diff >= 6 && diff < 12){
        //         System.out.println("20 rs charged");
        //     }else {
        //         System.out.println("25 rs charged");
        //     }
        // }else{
        //     System.out.println("time limit reached");
        // }

        /* if(diff < 24 && diff >= 0){
            // if(diff == (int)diff){
            //     System.out.println(diff * 10 + " charged"); 
            // }else{
            //     System.out.println(((int)diff * 10) + 10 +  " charged");
            // }

            if(diff % 1 == 0){
                System.out.println(diff * 10);
            }else{
                System.out.println((int)diff * 10 + 10);
            }
        }else{
            System.out.println("time limit reached");
        } */

        char ch = '2';

        System.out.println(Character.getNumericValue(ch));


    }
}
