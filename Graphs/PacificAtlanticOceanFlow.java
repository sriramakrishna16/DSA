import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


//problem given a matrix representing that top and left corners touches pacific ocean,
//bottom and right corners touches the atlantic ocean
//so that if raining starts falling on it, which grid or cell responsible for water 
//that drops or fall into both oceans based on heights.
//for example center cell height is 6 , diagonal heights are lower so falls diagonally and at corner
//at corner , rain drops into both pacific and atlantic ocean 
// all the cells which are true and responsible between the center grid and corner grid become correct.
//in this way we have to return all cells that are responsible for dropping water into both oceans.

//we use reverse dfs , because it is easier than normal dfs .we calculate from the ocean side[both]
// and moves to higher cell for both oceans separately and mark as true
//at last we compare the both ocean cells and returns the common cells.[true]

public class PacificAtlanticOceanFlow{

    //{1,0} - bottom {-1,0} - up {0,1} - right {0,-1} - left
    public static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}}; 
    public static void main(String args[]){
        int [] [] heights = { 
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}};

        List<List<Integer>> ans = ocean(heights);

        System.out.println(ans);
    }
    public static List<List<Integer>> ocean(int[][] heights){
        //initialising result array to add all final cells
        List<List<Integer>> result = new ArrayList<>();

        int row = heights.length;
        int col = heights[0].length;

        //creating matrix for both oceans initially false
        boolean [][] pacific = new boolean [row][col];
        boolean [][] atlantic = new boolean [row][col];

        //pacific
        for(int c = 0; c < col; c++){
            dfs(0,c,pacific,heights);
        }
        
        for(int r = 0; r < row; r++){
            dfs(r,0,pacific,heights);
        }

        //atlantic
        for(int c = 0; c < col; c++){
            dfs(row - 1,c,atlantic,heights);
        }

        for(int r = 0 ; r < row ; r++){
            dfs(r,col-1,atlantic, heights);
        }

        for(int r = 0 ; r < row ; r++){
            for(int c = 0 ; c < col ; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }
    public static void dfs(int row, int col, boolean [][] visited, int[][] heights){

        visited[row][col] = true;

        for(int[] dir : directions ){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow < 0 || newCol < 0 || newRow >= heights.length || newCol >= heights.length){
                continue;
            }

            if(visited[newRow][newCol]){
                continue;
            }

            if(heights[newRow][newCol] < heights[row][col]){
                continue;
            }

            dfs(newRow,newCol,visited,heights);
        }

    }
}