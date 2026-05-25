package DynamicProgramming;

import java.util.Arrays;

//problem states that at each index given a value , so that we use that value to max jump from index -
// or current position. so that if we can reach last index return true or else false.
// for this ,dp is not a optimal solution because we only look forward and unwanted calculations are done.
//example ,value = 3 , we can use 3 to reach end , but dp calculates between values to reach

public class JumpGame {
    public static void main(String args[]){
        int nums[] = {2,3,1,1,4};
        boolean ans = jump(nums);
        System.out.println(ans);
    }

    
    // public static boolean jump(int[] nums){
    //     int len = nums.length;
    //     boolean [] dp = new boolean [len];
    //     Arrays.fill(dp,false);
    //     dp[0] = true;

    //     for(int i = 0; i < len-1 ;i++){
    //         if(dp[i] == true){
    //             int maxJump = Math.min(len-1, i + nums[i]); //2
    //             for(int j = i + 1; j <= maxJump;j++){ //
    //                     dp[j] = true;
    //             }
    //         }
    //     }
    //     return dp[len - 1];
    // }

    //optimised version using greedy approach

    public static boolean jump(int[] nums){
        int len = nums.length;

        int maxReach = 0;
        

        for(int i = 0; i<len; i++){

            if(i > maxReach){
                return false;
            }

            maxReach = Math.max(i + nums[i], maxReach);

            if(maxReach >= len-1){
                return true;
            }

        }
        return true;
    }
}
