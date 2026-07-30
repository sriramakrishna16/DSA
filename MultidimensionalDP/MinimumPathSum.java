package MultidimensionalDP;

public class MinimumPathSum {
    public static void main(String args[]){
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int ans = minPathSum(grid);
        System.out.println(ans);
    }

    public static int minPathSum(int [][] grid){
        int c = grid[0].length;
        int r = grid.length;
        int [] dp = new int[c];
        dp[0] = grid[0][0];
        for(int i = 1 ; i < c ; i++){
            dp[i] = grid[0][i] + dp[i-1];
        }
        for(int i = 1; i < r ; i++){
            dp[0] = grid[i][0] + dp[0];
            for(int j = 1 ; j < c ; j++){
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);  
            }
        }
        return dp[c-1];
    }
}
