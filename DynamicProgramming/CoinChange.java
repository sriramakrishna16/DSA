package DynamicProgramming;

import java.util.Arrays;

public class CoinChnage {
    public static void main(String args[]){
        int [] coins = {1,2,5};
        int amount = 111;
        int totalCoins = findChange(coins, amount);
        System.out.println(totalCoins);
    }
    public static int findChange(int[] coins, int amount){
        int max = amount + 1;
        int dp[] = new int [max];
        Arrays.fill(dp,max);

        dp[0] = 0;

        for(int i = 1; i < max; i++){
            for(int coin : coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
