public class ValidSudoko {
    public static void main(String args[]){
        char [][] board = {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        boolean ans = isValid(board);
        System.out.println(ans);
    }
    public static boolean isValid(char[][] board){
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i<9; i++){
            for(int j = 0 ; j < 9; j++){
                char ch = board[i][j];
                if(ch == '.'){
                    continue;
                }
                int num = board[i][j] - '1';
                int box = (i/3) * 3 + (j/3);
                if(rows[i][num] || cols[j][num] || boxes[box][num]){
                    return false;
                }
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[box][num] = true;
            }
        }
        
        return true;
    }
}
