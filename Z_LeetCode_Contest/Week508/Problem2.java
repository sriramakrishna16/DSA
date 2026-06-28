package Z_LeetCode_Contest.Week508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//problem , this is a leetcode contest problem that given set of intervals represents busy time,
// and also given freetime -> start and end
// so that we have to merge intervals including touch intervals (end 7 , start 8 -> merged)
// after merging , we have to remove freetime from the busy time.
// and then return the result.

public class Problem2 {
    public static void main(String args[]){
        int [][] occupiedIntervals = {{2,6},{4,8},{10,10},{10,12},{14,16}};
        int freeStart = 7;
        int freeEnd = 11;
        List<List<Integer>> ans = merge(occupiedIntervals, freeStart, freeEnd);
        System.out.println(ans);
    }
    public static List<List<Integer>> merge(int[][] occupiedIntervals, int freeStart, int freeEnd){
        int [][] novalethri = occupiedIntervals;
        Arrays.sort(novalethri,(a,b) -> Integer.compare(a[0],b[0]));

        List<List<Integer>> merged = new ArrayList<>();

        for(int[] interval : novalethri){
            if(merged.isEmpty() || merged.get(merged.size() - 1).get(1)+1 < interval[0]){
                List<Integer> temp = new ArrayList<>();
                temp.add(interval[0]);
                temp.add(interval[1]);
                merged.add(temp);
            }else{
                merged.get(merged.size()-1).set(1,Math.max(interval[1],merged.get(merged.size() -1).get(1)));
            }
        }

        //if we take List<int[]> then, we we have to convert

        // List<List<Integer>> result = new ArrayList<>();

        // for(int[] arr : merged){
        //     result.add(Arrays.asList(arr[0],arr[1]));
        // }

        //now removing the free interval

        List<List<Integer>> result = new ArrayList<>();

        for(List<Integer> interval : merged){
            int s = interval.get(0);
            int e = interval.get(1);

            if(s > freeEnd || e < freeStart){
                result.add(List.of(s,e));
                continue;
            }

            if(s < freeStart){ // 2 < 7
                result.add(List.of(s, freeStart - 1));
            }

            if(e > freeEnd){
                result.add(List.of(freeEnd+1, e));
            }
        }

        return result;
    } 
}