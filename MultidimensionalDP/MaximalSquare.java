package MultidimensionalDP;

public class MaximalSquare {
    public static void main(String args[]){
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int ans = maxSquare(matrix);
        System.out.println(ans);
    }

    public static int maxSquare(char[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [][] dp = new int[rows+1][cols+1];
        int maxSide = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j<cols ; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;  
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
