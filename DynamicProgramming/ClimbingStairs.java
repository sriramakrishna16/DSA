package DynamicProgramming;

public class ClimbingStairs {
    public static void main(String args[]){
        int steps = 12;
        int ans = findPossibleWays(steps);
        System.out.println(ans);
    }
    // public static int findPossibleWays(int steps){
    //     int [] dp = new int [steps + 1];
        
    //     if(steps <= 2) return steps;

    //     dp[0] = 1;
    //     dp[1] = 1;

    //     for(int i = 2; i <= steps; i++){
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[steps];
    // }

    //space optimised solution

    public static int findPossibleWays(int steps){
        int prev1 = 2;
        int prev2 = 1;

        for(int i = 3; i<=steps; i++){
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
