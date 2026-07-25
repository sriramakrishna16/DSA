public class NQueens2 {
    public static void main(String args[]){
        int n = 4;
        int ans = totalNQueens(n);
        System.out.println(ans);
    }
    static int count = 0;
    static boolean cols [];
    static boolean diag1[];
    static boolean diag2[];
    public static int totalNQueens(int n){
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        backtrack(0,n);
        return count;
    }
    public static void backtrack(int row , int n){
        if(row == n){
            count++;
            return;
        }
        for(int col = 0; col < n ; col++){
            int d1 = row - col + n - 1;
            int d2 = row + col;
            if(cols[col] || diag1[d1] || diag2[d2]){
                continue;
            }
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1 , n);

            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
