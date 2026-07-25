package A_Fundamentals;
import java.util.Scanner;

public class ReadNumbers {
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int pos = 0,neg=0,zero=0;
        start(pos,neg,zero);
    }
    static void start(int pos, int neg, int zero){
        System.out.println("enter number (enter * to stop))");
        String ans = input.next();
        if(!ans.equals("*")){
           double num = Double.valueOf(ans);
           if(num > 0) pos++;
           else if(num < 0) neg++;
           else zero++;
           start(pos, neg, zero);
        }else if(ans.equals("*")){
            System.out.println("count of positive numbers :" + pos);
            System.out.println("count of negative numbers :" + neg);
            System.out.println("count of zero's numbers :" + zero);
        }
    }

    /* public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int pos = 0,neg=0,zero =0;
        while (true) {
            System.out.print("Enter a number (* to stop): ");
            String ans = input.next();
            
            if (ans.equals("*")) 
                break;

            double num = Double.valueOf(ans);
            if (num > 0) pos++;
            else if (num < 0) neg++;
            else zero++;
        }
        System.out.println("Count of positive numbers : " + pos);
        System.out.println("Count of negative numbers : " + neg);
        System.out.println("Count of zeros            : " + zero);
    } */
}
