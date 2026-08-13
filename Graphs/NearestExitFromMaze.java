import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromMaze{
    public static void main(String [] args){
        char [][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int [] entrance = {1,2};
        int ans = nearestExit(maze, entrance);
        System.out.println(ans);
    }
    public static int nearestExit(char [][] maze, int[] entrance){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0],entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i = 0; i < size; i++){
                int[] a = q.poll();
                int row = a[0];
                int col = a[1];
                for(int[] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow < 0 || newCol < 0 || newRow >= maze.length || newCol >= maze[0].length){
                        continue;
                    }
                    if(maze[newRow][newCol] == '+'){
                        continue;
                    }
                    maze[newRow][newCol] = '+';
                    if(newRow == 0 || newCol == 0 || newRow == maze.length-1 || newCol == maze[0].length-1 && 
                            !(newRow == entrance[0] && newCol == entrance[1])){
                        return steps;
                    }
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        return -1;
    }
}