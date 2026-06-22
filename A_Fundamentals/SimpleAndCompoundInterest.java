import java.util.Scanner;

public class SimpleAndCompoundInterest {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("enter principal amount");
        double principal = input.nextDouble();

        System.out.println("enter rate of interest");
        double rate = input.nextDouble();

        System.out.println("enter total duration");
        double time = input.nextDouble();

        double si = principal * rate * time / 100;

        System.out.println("simple interest is :" + si);

        double A = principal * Math.pow((1 + rate/100),time);

        double ci = A - principal;

        System.out.println("compound interest is :" + ci);

        input.close();
    }
}
