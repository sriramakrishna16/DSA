//problem. leetcode contest 509 -> Sum of Integers with Maximum Digit Range

//we have find the range for each num in integer array and update the maxRange among all.
// we can find range by maxDigit - min digit in each num.

//after finding maxrange , we have to sum all nums in array which contains the digit maxRange

public class P1_SumOfIntegerWithMaxDigitRange{
    public static void main(String args[]){
        int nums [] = {5724,111,350};
        int ans = findSum(nums);
        System.out.println(ans);
    }
    public static int findSum(int [] nums){
        int maxRange = -1;
        int sum = 0;
        for(int num : nums){
            int big = 0;
            int small = 9;
            int temp = num;
            while(temp > 0){
                int digit = temp % 10;
                temp /= 10;
                big = Math.max(big, digit);
                small = Math.min(small, digit);
            }
            int range = big - small;
            big = 0;
            small = 9;
            if(range > maxRange){
                maxRange = range;
                sum = num;
            }else if(range == maxRange){
                sum += num;
            }
        }
        return sum;
    }
}