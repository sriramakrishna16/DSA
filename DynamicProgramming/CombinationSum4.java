package DynamicProgramming;

public class CombinationSum4 {
    public static void main(String args[]){
        int [] nums = {1,2,3};
        int target = 4;
        int ans = findWays(nums, target);
        System.out.println(ans);
    }
    public static int findWays(int [] nums, int target){
        int len = nums.length;
        int [] dp = new int [target + 1];

        dp[0] = 1;
        for(int i = 1 ; i<= target ; i++){
            for(int num : nums){
                if(i >= num){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
