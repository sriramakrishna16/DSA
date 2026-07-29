package Math;
import java.util.*;

public class PlusOne {
    public static void main(String [] args){
        int digits[] = {1,2,3};
        int [] ans = add(digits);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] add(int [] digits){
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
