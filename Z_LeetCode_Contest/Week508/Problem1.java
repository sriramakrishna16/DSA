package Z_LeetCode_Contest.Week508;

import java.util.Arrays;

//problem, given an array in unsorted order , k which indicated no of values to use, multiplication number
// that decreases after each operation

//goal is to return max sum that we have to take in any order for k no of values only and multiply with each 
// number with mul variable and it decreases for each multiplication , multiplication is our choice. that means
// if multiplication increases maxsum then we use it or we just dont include multiplication

public class Problem1 {
    public static void main(String args[]){
        int nums [] = {4,4};
        int k = 1;
        int mul = 1;
        long ans = findMax(nums,k,mul);
        System.out.println(ans);
    }
    public static long findMax(int[] nums, int k , int mul){
        Arrays.sort(nums);
        long max = 0;
        for(int i = nums.length - 1 ; i >= nums.length - k ; i--){
            if(mul > 1){
                max += (long)nums[i] * mul;
            }else{
                max += (long)nums[i];
            }
            mul--;
        }
        return max;
    }
}
