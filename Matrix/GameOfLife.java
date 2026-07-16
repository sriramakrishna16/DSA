import java.util.Arrays;
//problem , given 2D array of integers and we have to change matrix according to GameOfLife rules.

//They are...
// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
public class GameOfLife {
    public static void main(String args[]){
        int [][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for(int [] x: board){
            System.out.println(Arrays.toString(x));
        }
    }
    public static void gameOfLife(int [][] board){
        int [][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int m = board.length;
        int n = board[0].length;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int live = 0;
                for(int [] d : dir){
                    int r = i + d[0];
                    int c = j + d[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == -1 || board[r][c] == 1)){
                        live++;
                    }
                }
                if(board[i][j] == 1){
                    if(live < 2 || live > 3){
                        board[i][j] = -1;
                    }
                }else{
                    if(live == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i =0; i < m ; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }else if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
                    
    }
}
