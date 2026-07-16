package HashMap;
import java.util.*;

public class HappyNumber {
    public static void main(String args[]){
        int n = 19;
        boolean ans = isHappy(n);
        System.out.println(ans);
    }
    public static boolean isHappy(int n){
        HashSet<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            int sum = 0;
            set.add(n);
            while(n > 0){
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n==1;
    }
}
