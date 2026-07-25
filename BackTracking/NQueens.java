import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens{
    public static void main(String args[]){
        int n = 4;
        List<List<String>> ans = solveNQueens(n);
        System.out.println(ans);
    }
    static List<List<String>> ans = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];
        for(int i = 0 ; i<n ; i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(board,0);
        return ans;
    }
    public static void backtrack(char [][] board, int row){
        if(row == board.length){
            ans.add(construct(board));
        }

        for(int col = 0 ; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }
    public static boolean isSafe(char[][] board, int row , int col){
        for(int i = 0 ; i < row ; i++){
            if(board[i][col] == 'Q')
                return false;
        }

        for(int r = row - 1 , c = col - 1 ; r >= 0 && c >= 0 ; r--,c--){
            if (board[r][c] == 'Q')
                return false;
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q')
                return false;
        }

        return true;
    }
    public static List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}