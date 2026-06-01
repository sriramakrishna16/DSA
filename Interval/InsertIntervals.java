package Interval;

import java.util.Arrays;

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
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            if (interval[1] < newInterval[0]) {
                result.add(interval);
            }

            else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval;
            }

            // Overlapping intervals
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
