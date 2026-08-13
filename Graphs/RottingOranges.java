import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges{
    public static void main(String [] args){
        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int ans = orangesRotting(grid);
        System.out.println(ans);
    }

    public static int orangesRotting(int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0 ; i<grid.length; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int minutes = 0;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int [] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int [] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length){
                        continue;
                    }
                    if(grid[newRow][newCol] != 1){
                        continue;
                    }
                    grid[newRow][newCol] = 2;
                    fresh--;
                    q.offer(new int[]{newRow, newCol});
                }
            }
            minutes++;
        }
        if  (fresh > 0){
            return -1;
        }
        return minutes;
    }
}