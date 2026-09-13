package Z_LeetCode_Contest.Week519;
import java.util.Arrays;

public class CyclicallyShiftRowsColumns {
    public static void main(String []args){
        int n = 2;
        int[][] grid = {{1,2},{3,4}};
        int [] rowShift = {1,0};
        int [] colShift = {0,1};
        int[][] output = cyclicShift(n, grid, rowShift, colShift);
        System.out.println(Arrays.toString(output));
    }
    public static int[][] cyclicShift(int n , int[][] grid, int[] rs, int[] cs){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n; i++){
            int k = rs[i] % n;
            for(int j = 0; j < n; j++){
                int newCol = (j - k + n) % n;
                temp[i][newCol] = grid[i][j];
            }
        }

        int[][] result = new int[n][n];
        for(int j = 0 ; j < n ; j++){
            int k = cs[j] % n;
            for(int i = 0; i < n; i++){
                int newRow = (i-k+n)%n;
                result[newRow][j] = temp[i][j];
            }
        }
        return result;
    }
}
