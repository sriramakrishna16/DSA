package Interval;

import java.util.PriorityQueue;
import java.util.Arrays;


//problem . given array of intervals , and based on intervals we have to arrange rooms
//so from given intervals ,we have to return how many rooms needed.
//if interval is running and new interval with time overlaps with running interval,
// we have to arrange new room for meeting to run
//if current interval finished at when another starts , simply we utilize the same room.

//we use min heap method to solve this, before we have to sort the intervals by start time
// and store first end time in min heap , and when adding another interval into min heap , we have to check 
//current interval is completed or running at the time of new interval.  

//if completed simple we remove from heap and add next interval means we are utilizing same room
// that is -> new interval start time > running interval end time , room is free 
//if not , we have to assign new room that is adding new interval end time 
//at last we have to retun the size of minHeap.

public class MeetingRooms2 {
    public static void main(String args[]){
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        int totalRooms = rooms(intervals);
        System.out.println(totalRooms);
    }
    public static int rooms(int [][] intervals){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(intervals[0][1]);

        for(int i = 1; i < intervals.length ; i++){
            if(intervals[i][0] >= minHeap.peek()){
                minHeap.poll();
            }

            minHeap.offer(intervals[i][1]);
        }

        return minHeap.size();
    }
}
