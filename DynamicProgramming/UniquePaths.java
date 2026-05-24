package DynamicProgramming;

//problem given a matrix with m and n , then we have to start at first position[1][1] and reach end[m][n],
//and find no of possible ways to reach end by only moving down and right
//core idea , for every point in matrix, we came from either top or left , so top + left = total possibility
//of that position...

public class UniquePaths {
    public static void main(String args[]){
        int m = 3;
        int n = 7;
        int ans = findWays(m,n);
        System.out.println(ans);
    }
    public static int findWays(int m, int n){   // 0 0 0 0 0 0 0

        int [][] dp = new int [m+1][n+1];

        // for(int i = 0; i<m;i++){
        //     dp[i][0] = 1
        // }

        // for(int i = 0; i<m;i++){
        //     dp[0][i] = 1
        // }

        //no need for initialising first row and column as 1 value initially,
        //if we take dummy row and column and add 1 in left or top as initial step

        dp[0][1] = 1; //taking top as initial step

        for(int i = 1; i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }
}
