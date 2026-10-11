package Z_LeetCode_Contest.Biweekly193;

import java.util.Arrays;
import java.util.HashMap;
public class MaxProductPairWithTargetSum {
    public static void main(String [] args){
        int [] nums = {1,2,4,3};
        int target = 5;
        int [] ans = maxProductPair(nums, target);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] maxProductPair(int [] nums, int target){
        // int max = 0;
        // int [] ans = {-1,-1}; 
        // for(int i = 0 ; i < nums.length; i++){
        //     for(int j = 0 ; j < nums.length; j++){
        //         if(i != j && nums[i] + nums[j] == target && nums[i] > nums[j]){
        //             int product = nums[i] * nums[j];
        //             if (product > max){
        //                 ans[0] = i;
        //                 ans[1] = j;
        //             }
        //         }
        //     }
        // }
        // return ans;
        

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int ans [] = {-1,-1};
        for(int i = 0 ; i < nums.length; i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment) && compliment != nums[i]){
                int product = compliment * nums[i];
                if (product > max){
                    if(compliment > nums[i]){
                        ans[0] = map.get(compliment);
                        ans[1] = i;
                    }else{
                        ans[0] = i;
                        ans[1] = map.get(compliment);
                    }
                    max = product;
                }
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
