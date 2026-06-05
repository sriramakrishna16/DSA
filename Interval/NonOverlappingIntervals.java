package Interval;

import java.util.Arrays;


//problem, given an array of intervals
//return the number of intervals(count) needed to remove to make intervals non overlapping

public class NonOverlappingIntervals {
    public static void main(String[] args) {

        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        int result = removeOverlaps(intervals);
        System.out.println("Minimum intervals to remove: " + result);
    }
    public static int removeOverlaps(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < prevEnd) {
                removals++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
