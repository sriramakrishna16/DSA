package Interval;

import java.util.Arrays;


//problem given array of non overlapping intervals, and insert the new interval into given intervals
// and merge overlapping intervals and return the final intervals


public class InsertIntervals {
    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = {2, 5};

        int[][] result = insert(intervals, newInterval);

        System.out.println("Merged Intervals:");

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    //single loop solution

    // public static int[][] insert(int[][] intervals, int[] newInterval) {

    //     List<int[]> result = new ArrayList<>();

    //     for (int[] interval : intervals) {

    //         if (interval[1] < newInterval[0]) {
    //             result.add(interval);
    //         }

    //         else if (interval[0] > newInterval[1]) {
    //             result.add(newInterval);
    //             newInterval = interval;
    //         }

    //         // Overlapping intervals
    //         else {
    //             newInterval[0] = Math.min(newInterval[0], interval[0]);
    //             newInterval[1] = Math.max(newInterval[1], interval[1]);
    //         }
    //     }

    //     result.add(newInterval);

    //     return result.toArray(new int[result.size()][]);
    // }


    //easiest way 

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        //adding non-overlapping intervals by comparing with new interval
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        //if overlapping happens , then we can loop until where it can go without overlapping...
        //compares newInterval[1] and interval[0] , so we can find the exact interval by merging all of them
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        //after merging , we add into result
        result.add(newInterval);

        //if any left, we add
        while(i < n){
            result.add(intervals[i]);
            i++;
        }

        //return expects 2D array , so we convert it.
        return result.toArray(new int[result.size()][]);
    }

}
