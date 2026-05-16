package DynamicProgramming;


//Dynamic programming is not a best approach . It takes n * n times beacuse
// it have to check all previous elements(j) for every elemnt (i)


//Dynamic Approach

public class LongestIncreasingSubsequence {
    public static void main(String [] args){
        int nums [] = {10,9,2,5,3,7,101,18,110};
        int longestSeq = findSequence(nums);
        System.out.println(longestSeq);
    }

    public static int findSequence(int nums[]){
        
        int n = nums.length;

        int dp [] = new int [n];

        for (int i = 0 ; i<n ; i++){
            dp[i] = 1;
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;

        for(int x : dp){
            max = Math.max(max, x);
        }
        return max;
    }
}
