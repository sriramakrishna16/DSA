package Interval;

import java.util.List;
import java.util.*;

//problem , given an array of intervals , so we have to merge all overlapping intervals
//there is no statement that array intervals are sorted, so it can be in unsorted order.

//merging unsorted intervals results in increasing time complexity, so we first sort 
// and then we compare and merge into ArrayList and then return by converting into 2D array.

public class MergeIntervals {
    public static void main(String args[]){
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [][] result = merge(intervals);
        for(int[] set : result){
            System.out.print(Arrays.toString(set) + " ");
        }
    }

    public static int [][] merge(int[][] intervals){
        List<int[]> result = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for(int [] interval : intervals){
            if(result.size() == 0 || result.get(result.size()-1)[1] < interval[0]){
                result.add(interval);
            }
            else{
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
