import java.util.*;

public class Ladders {
    public static void main(String args[]){
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        int ans = ladders(board);
        System.out.println(ans);
    }
    public static int ladders(int[][] board){
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        q.offer(1);
        visited[1] = true;
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                if(curr == n * n){
                    return moves;
                }
                for(int dice = 1 ; dice <= n && curr + dice <= n * n ; dice++){
                    int next = curr + dice;
                    int [] pos = getPosition(next, n);
                    int row = pos[0];
                    int col = pos[1];
                    if(board[row][col] != -1){
                        next = board[row][col];
                    }
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    public static int [] getPosition(int next, int n){
        int rowFromBottom = (next - 1) / n;
        int row = n - 1 - rowFromBottom;
        int col = (next - 1) % n;
        if(rowFromBottom % 2 == 1){
            col = n - 1 - col;
        }
        return new int[]{row, col};
    } 
}
