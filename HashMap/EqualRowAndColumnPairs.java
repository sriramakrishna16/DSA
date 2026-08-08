import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//problem , given 2D array of grid , we have to return the count for which rows and columns are equal.

public class EqualRowAndColumnPairs{
    public static void main(String [] args){
        int [][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        int ans = equalPairs(grid);
        System.out.println(ans);
    }
    public static int equalPairs(int[][] grid){
        HashMap<List<Integer>,Integer> map = new HashMap<>();
        int n = grid.length;
        for(int i = 0 ; i < n ; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                row.add(grid[i][j]);
            }
            map.put(row, map.getOrDefault(row,0)+1);
        }

        int count = 0;
        for(int j = 0 ; j < n ; j++){
            List<Integer> col = new ArrayList<>();
            for(int i = 0; i < n ; i++){
                col.add(grid[i][j]);
            }
            count += map.getOrDefault(col,0);
        }

        return count;

        //Same code but for better understanding.

        // HashMap<List<Integer>,Integer> map1 = new HashMap<>();
        // int n = grid.length;
        // for(int i = 0 ; i < n ; i++){
        //     List<Integer> row = new ArrayList<>();
        //     for(int j = 0 ; j < n ; j++){
        //         row.add(grid[i][j]);
        //     }
        //     map1.put(row, map1.getOrDefault(row,0)+1);
        // }
        // HashMap<List<Integer>,Integer> map2 = new HashMap<>();
        // for(int j = 0 ; j < n ; j++){
        //     List<Integer> col = new ArrayList<>();
        //     for(int i = 0; i < n ; i++){
        //         col.add(grid[i][j]);
        //     }
        //     map2.put(col, map2.getOrDefault(col,0)+1);
        // }
        // int count = 0;
        // for(Map.Entry<List<Integer>,Integer> entry : map1.entrySet()){
        //     List<Integer> row = entry.getKey();
        //     int rowFreq = entry.getValue();
        //     int colFreq = map2.getOrDefault(row, 0);
        //     count += rowFreq * colFreq;
        // }

        // return count;
    }
}