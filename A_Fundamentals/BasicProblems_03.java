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
                smallest = x; //1
            }
            i++;
        }
        System.out.println("Biggest values is :" + biggest);
        System.out.println("Smallest values is :" + smallest);  */ 

        //positive , negative and zero counts

        /* System.out.println("enter total no of values");
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
        System.out.println("negatives's count is :" + countNegative); */

        //using break
       /*  int i = 1;
        while(i <= 10){
            if(i > 5){
                break;
            }else{
                System.out.println(i);
            }
            i++;
        } */

        //using continue
        /* int i = 0;
        while(i < 10){
            i ++;
            if(i == 4 || i == 8){
                continue;
            }
            System.out.println(i);
        } */


        //leap years and total count in between two years.
        /* int start = 1900;
        int end = 2000;
        int leapYearCount = 0;
        while(start <= 2000){
            if(start % 400 == 0 || (start % 4 == 0 && start % 100 != 0)){
                System.out.println("leap year : " + start);
                leapYearCount++;
            }
            start++;
        }
        System.out.println("total leap years are :" + leapYearCount); */

        //printing patterns

        /* for(int r = 1; r<=5;r++){
            for(int c=1; c<=4;c++){
                while(c <= r){
                    System.out.print("* ");
                    c++;
                }
                break;
            }
            System.out.println();
        } */

        //while and while
        /* int r = 1;
        while(r <= 5){
            int c = 1;
            while(c <= r){
                System.out.print("* ");
                c++;
            }
            r++;
            System.out.println();
        } */

        //while and for loop

        /* int r = 1;
        while(r <= 5){
            for(int c = 1; c<=r ; c++){
                System.out.print("* ");
            }
            System.out.println();
            r++;
        } */

        //for and while
        /* for(int r = 1; r <= 5; r++){
            int c = 1;
            while(c <= r){
                System.out.print("* ");
                c++;
            }
            System.out.println();
        } */

        //1st pattern

        /* int r = 5;
        for(int i = 1; i<=r;i++){
            int c = 5;
            for(int j=1; j<=c-i+1;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        } */

        //2nd pattern 
        /* int r = 5;
        for(int i = 1; i<=r;i++){
            int c = 5;
            for(int j=1; j<=c-i+1;j++){
                System.out.print(j+i-1 + " ");
            }
            System.out.println();
        } */

        //3rd pattern
        /* int r = 5;
        for(int i = 1; i<=r;i++){
            int c = 5;
            for(int j=1; j<=c-i+1;j++){
                System.out.print(r-j + 1 + " ");
            }
            System.out.println();
        } */

        //4th pattern
        int r = 5;
        int e = r;
        for(int i = 1; i<=r;i++){
            int c = 5;
            for(int j=1; j<=c-i+1;j++){
                System.out.print(e - j + 1 + " ");
            }
            e--;
            System.out.println();
        }    


        //PATTERN 1 while and while
        /* int r = 5;
        int i = 1;
        while(i <= r){
            int c = 5;
            int j = 1;
            while(j <= c - i + 1){
                System.out.print(j + " ");
                j++;
            }
            System.out.println();
            i++;
        } */

        //Pattern2 while and while loop
        /* int r = 5;
        int i = 1;
        while(i <= r){
            int c = 5;
            int j = 1;
            while(j <= c - i + 1){
                System.out.print(j + i - 1 + " ");
                j++;
            }
            System.out.println();
            i++;
        } */

        //pattern3 while and while

        /* int r = 5;
        int i = 1;
        while(i <= r){
            int c = 5;
            int j = 1;
            while(j <= c - i + 1){
                System.out.print(r - j + 1 + " ");
                j++;
            }
            System.out.println();
            i++;
        } */
    }
}