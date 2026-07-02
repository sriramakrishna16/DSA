import java.util.*;

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
        /* int r = 5;
        int e = r;
        for(int i = 1; i<=r;i++){
            int c = 5;
            for(int j=1; j<=c-i+1;j++){
                System.out.print(e - j + 1 + " ");
            }
            e--;
            System.out.println();
        }  */   


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

        //printing prime numbers
        /* System.out.println("enter start number");
        int start = input.nextInt();
        System.out.println("enter end number");
        int end = input.nextInt();

        if(start > end){
            int temp = start;
            start = end;
            end = temp;
        }

        for(int i = start ; i<= end; i++){
            int count = 0; //2 = 0
            if(i == 1){
                continue;
            }
            for(int j = 1; j <= i; j++){ //1 <= 2
                if(i%j==0){
                    count++; //1+1 = 2
                }
            }
            if(count==2){
                System.out.print(i + " ");
            }
        } */


        //printing star pattern in borders

       /*  System.out.println("enter no of rows");
        int r = input.nextInt();
        System.out.println("enter no of columns");
        int c = input.nextInt();

        int i = 1;
        while(i <= r){
            int j = 1;
            while(j <= c){
                // if(i == 2 || i == 3 || i == 4){
                //     if(2 <= j && j <= 4){
                //         System.out.print("  ");
                //         j++;
                //         continue;
                //     }
                // }
                // System.out.print("* ");
                // j++; 

                if(i == 1 || i == r || j == 1 || j == c){
                    System.out.print("* ");         
                }else{
                    System.out.print("  ");
                }
                j++; 
            }
            System.out.println();
            i++;
        } */


        //reverse the array and finding big and smallest in array

        /* int [] arr = {10,278,3,430,57};

        int biggest=Integer.MIN_VALUE,smallest=Integer.MAX_VALUE;

        System.out.println("printing array in reverse order :");
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[arr.length - i - 1] + " ");

            if(arr[i] > biggest) 
                biggest = arr[i];
            if(arr[i] < smallest){
                smallest = arr[i];
            }
        }
        System.out.println();
        System.out.println("Biggest is :" + biggest);
        System.out.println("Smallest is :" + smallest);   



        //printing secondBig and secondSmall using array

        int big = Integer.MIN_VALUE,small = Integer.MAX_VALUE;

        int secondBig = 0,secondSmall = 0;

        int [] arr2 = {10,278,278,300,300,3,430,57,430,430};
        for(int x : arr2){
            if(x > big){
                secondBig = big;
                big = x;
            }else if(x > secondBig && x != big){
                secondBig = x;
            }
            if(x < small){
                secondSmall = small;
                small = x;
            }else if(x < secondSmall && x != small){
                secondSmall = x;
            }
        }
        System.out.println("second biggest is :" + secondBig);
        System.out.println("second small is :" + secondSmall);
        */

        //swapping array

        /* int arr[] = {1,2,3,4,5};
        for(int i = 0 ; i<arr.length/2; i++){
            // if(i == arr.length-i-1){
            //     break;
            // }
            int temp = arr[i]; 
            arr[i] = arr[arr.length - i - 1]; 
            arr[arr.length - i - 1] = temp;  
        }
        
        for(int x : arr){
            System.out.print(x + " ");
        } */

        //operations on arrays

        /* int[] arr1 = {1,2,3,4,5};
        int[] arr2 = arr1;
        for(int x : arr2){
            System.out.print(x + " ");
        }
        System.out.println();

        int[] arr3 = new int[arr1.length];
        for(int i = 0 ; i<arr1.length; i++){
            arr3[i] = arr1[i];
        }
        for(int y : arr3){
            System.out.print(y + " ");
        } */


        //extending and adding extra elements to array

        /* int[] arr1 = {1,2,3,4,5};

        int len = arr1.length;

        int[] arr2 = new int[len + 1];
        for(int i = 0; i < len ; i++){
            arr2[i] = arr1[i];
        }
        arr2[len] = 6;

        System.out.print(" array 2 is : ");
        for(int a : arr2){
            System.out.print(a + " ");
        }
        System.out.println();


        System.out.print("copied list is : ");
        List<Integer> arr3 = new ArrayList<>();

        for(int i = 0; i < len ; i++){
            arr3.add(arr1[i]);
        }
        arr3.add(6);

        System.out.println(arr3); */

        //insert operation
        /* int len = 5;
        int start = 0;
        int end = len - 1;

        int pos = 2;

        int [] x = new int[len];

        x[end] = 4;  
        x[start] = 1;
        x[pos] = 3;

        System.out.println("printing array values : ");
        for(int val : x){
            System.out.print(val + " ");
        }
        System.out.println(); */

        //deleting array values

        int [] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        int [] delete = new int[arr.length - 1];
        
        System.out.println("enter 1 to delete at start \nenter 2 to delete at end \nenter 3 to delete at specific position \nenter 4 to detele using value ");
        int choice = input.nextInt();

        /* if(choice == 1){
            for(int i = 0; i < arr.length - 1; i++){
                delete[i] = arr[i+1];
            }
        }
        if(choice == 2){
            for(int i = 0 ; i < arr.length - 1 ; i++){
                delete[i] = arr[i];
            }
        }
        if(choice == 3){
            System.out.println("enter the pos to delete :");
            int delInd = input.nextInt();
            for(int i = 0 ; i < arr.length - 1 ; i++){
                if (i < delInd) {
                    delete[i] = arr[i];
                } else {
                    delete[i] = arr[i + 1];
                }
            }
        }

        if(choice == 4){
            System.out.println("enter value :");
            int value = input.nextInt();
            for(int i = 0 ; i < arr.length - 1; i++){
                if(arr[i] < value){
                    delete[i] = arr[i];
                }else{
                    delete[i] = arr[i + 1];
                }
            }
        } */


        int delInd = -1,value = -1;
        if(choice == 3){
            System.out.println("enter the pos to delete :");
            delInd = input.nextInt();
        }
        if(choice == 4){
            System.out.println("enter value :");
            value = input.nextInt();
        }
        for(int i = 0; i<arr.length-1;i++){
            if(choice == 1){
                delete[i] = arr[i+1];
            }
            if(choice == 2){
                delete[i] = arr[i];
            }
            if(choice == 3){
                if (i < delInd) {
                    delete[i] = arr[i];
                } else {
                    delete[i] = arr[i + 1];
                }
            }
            if(choice == 4){
                if(arr[i] < value){
                    delete[i] = arr[i];
                }else{
                    delete[i] = arr[i + 1];
                }
            }
        }

        for(int o : delete){
            System.out.print(o + " ");
        }
        System.out.println();


        
        
    } 
}