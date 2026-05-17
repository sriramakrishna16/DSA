package DynamicProgramming;

public class LongestCommonSubsequence {
    public static void main (String args[]){
        String text1 = "abcdeff";
        String text2 = "acef";
        int ans = findLCS(text1, text2);
        System.out.println(ans);
    }
    public static int findLCS(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        int [][] dp = new int [m + 1][n + 1];

        for(int i = 1; i<=m; i++){
            for(int j = 1; j<= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
