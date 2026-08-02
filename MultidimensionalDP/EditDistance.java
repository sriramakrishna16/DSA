package MultidimensionalDP;

public class EditDistance {
    public static void main(String args[]){
        String str1 = "horse";
        String str2 = "ros";
        int ans = minDistance(str1, str2);
        System.out.println(ans);
    }

    public static int minDistance(String str1, String str2){
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1];
                    int delete = dp[i - 1][j];   
                    int insert = dp[i][j - 1]; 
                    dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
                }
            }
        }

        return dp[m][n];
    }
}
