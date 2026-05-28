package Graphs;

public class NumberOfIslands {

    public static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}}; 

    public static void main(String args[]){
        int [][] islands = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}};

        int ans = findIslands(islands);
        System.out.println(ans);
    }
    public static int findIslands(int[][] islands){

        int count = 0;

        int row = islands.length;
        int col = islands[0].length;

        boolean [][] land = new boolean[row][col];

        for(int r = 0; r<row ; r++){
            for(int c = 0; c<col; c++){
                if(!land[r][c] && islands[r][c]!= 0){
                    dfs(r,c,land,islands);
                    count += 1;
                }
            }
        }
        return count;
    }
    public static void dfs(int r, int c, boolean[][] visited, int[][] islands){

        visited[r][c] = true;

        for(int[] dir : directions){
            int newRow = r + dir[0];
            int newCol = c + dir[1];

            if(newRow < 0 || newCol < 0 || newRow >= islands.length || newCol >= islands[0].length){
                continue;
            }

            if(visited[newRow][newCol]){
                continue;
            }

            if(islands[newRow][newCol] == 0){
                continue;
            }

            dfs(newRow , newCol , visited, islands);

        }

    }

}
