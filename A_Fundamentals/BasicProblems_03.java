import java.util.Scanner;

public class BasicProblems_03{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        //problem 1 : factorial of n

       /*  System.out.println("enter the number");
        int n = input.nextInt();
        int counter = n;
        int fact = 1;
        int i = 1;
        while(counter >= 1){
            fact = fact * counter;
            counter--;
            i++;
        }
        System.out.println("factorial of " + n + " * " + i + " is :" + fact); */


        //sum of n natural numbers in decrementing

        /* Scanner input = new Scanner(System.in);
        System.out.println("enter the number");
        int n = input.nextInt();
        int counter = n;
        int sum = 0;
        while(counter >= 1){  
            sum += counter;
            counter--;
        }

        System.out.println("sum of " + n + " is : " + sum); */

        //count of even numbers and odd numbers

        /* System.out.println("enter a number");
        int n = input.nextInt();

        int oddCount=0,evenCount=0;

        int i = 1;
        while(i <= n) {
            if(i % 2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }
            i++;
        }
        System.out.println("odd count is :" + oddCount);
        System.out.println("even count is :" + evenCount); */

        //printing biggest and smallest value among n values

        /* System.out.println("enter total number of values");
        int n = input.nextInt();

        int biggest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;

        int i = 1;
        while(i <= n){
            System.out.println("enter " + i + " " + "value");
            int x = input.nextInt();
            if(x > biggest){   
                biggest = x; //34
            }
            if( x < smallest){ // 1< 34
                smallest = x; //34
            }
            i++;
        }
        System.out.println("Biggest values is :" + biggest);
        System.out.println("Smallest values is :" + smallest);  */ 

        //positive , negative and zero counts

        System.out.println("enter total no of values");
        
        int n = input.nextInt();
        int countZero = 0, countPositive = 0, countNegative = 0;
        int i = 1;
        while(i <= n){
            System.out.println("enter " + i + " value");
            int x = input.nextInt();
            if(x > 0){
                countPositive++;
            }else if(x < 0){
                countNegative++;
            }else{
                countZero++;
            }
            i++;
        }
        System.out.println("zero's count is :" + countZero);
        System.out.println("positives's count is :" + countPositive);
        System.out.println("negatives's count is :" + countNegative);
    }
}