package DynamicProgramming;

public class MinimumCostClimbingStairs {
    public static void main(String[] args){
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int ans = minCost(cost);
        System.out.println(ans);
    }

    public static int minCost(int[] cost){
        // int prev1 = cost[0];
        // int prev2 = cost[1];
        // int ans = 0;
        // for(int i = 2 ; i < cost.length ; i++){
        //     int current = cost[i] + Math.min(prev1, prev2);
        //     prev1 = prev2;
        //     prev2 = current;
        // }
        // return Math.min(prev1,prev2);

        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n ; i++){
            dp[i] = Math.min(dp[i-1]+ cost[i-1],dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
