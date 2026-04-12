package BitManipulations;

//problem : sum of two integers without using + operator..

public class SumOfTwoIntegers{
    public static void main(String args[]){
        int a = 111111200;
        int b = 111111350;
        int ans = Sum(a,b);
        System.out.println(ans);
    }
    public static int Sum(int a, int b){
        while(b !=0){
            int carry = (a & b) << 1;
            a = a ^ b; 
            b = carry;
        }
        return a;
    }
}