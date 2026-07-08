package LeetcodeEasy;

public class CountDigitsThatDivideNumber {
    public static void main(String args[]){
        int num = 7;
        int ans = findDivisibleDigits(num);
        System.out.println(ans);
    }

    public static int findDivisibleDigits(int num){
        int count = 0;
        int dup = num;
        while(dup > 0){
            int digit = dup % 10;
            if(num % digit == 0){
                count++;
            }
            dup /= 10;
        }
        return count;
    }
}
