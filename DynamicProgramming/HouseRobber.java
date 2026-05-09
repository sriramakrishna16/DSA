package DynamicProgramming;

public class HouseRobber {
    public static void main(String args[]){
        int [] houses = {1,2,3,1};
        int robbedAmount = rob(houses);
        System.out.println(robbedAmount);
    }
    public static int rob(int [] houses){
        int m = houses.length;

        if(m==0) return m;
        if(m == 1) return houses[0];

        int dp[] = new int[m];
        dp[0] = houses[0];
        dp[1] = Math.max(dp[0], houses[1]);

        for(int i = 2; i<m ; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + houses[i]);
        }
        return dp[m-1];
    }
}
