package MultidimensionalDP;

public class UniquePaths2 {
    public static void main(String args[]){
        int [][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        int ans = uniquePaths(grid);
        System.out.println(ans);
    }

    public static int uniquePaths(int[][] grid){
        int c = grid[0].length;
        int r = grid.length;
        int [] dp = new int[c];
        dp[0] = 1;

        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(grid[i][j] == 1){
                    dp[j] = 0;
                }else if(j > 0){
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[c-1];
    }
}
