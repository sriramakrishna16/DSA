package Z_LeetCode_Contest.Biweekly191;

// problem , given a target score n
// score starts at 0 and each day increase one like 1,2,3,4
// if we skip any day then points starts counting from 1 again like streak
// we have to return the min number of days to needed to score the target n

// ex : if n = 2, day 1 = 1 , score = 1, day2 = 2, score = 3 we are crossing the target
// so skip day2 , score = 1, day3 = 1, score = 2 , so total days = 3.

public class MinimumDaysToScoreExactlyNPoints {
    public static void main(String[] args){
        int n = 2;
        int days = minDays(n);
        System.out.println(days);
    }
    public static int minDays(int n){
        int[] dp = new int[n+1];
        int INF = Integer.MAX_VALUE / 2;

        for(int i = 1 ; i <= n ; i++){
            dp[i] = INF;
            for(int k = 1; k * (k+1)/2 <= i; k++){
                int points = k * (k+1) / 2;
                if(points == i){
                    dp[i] = Math.min(dp[i], k);
                }else{
                    dp[i] = Math.min(dp[i], dp[i-points] + k + 1);
                }
            }
        }
        return dp[n];
    } 
}
