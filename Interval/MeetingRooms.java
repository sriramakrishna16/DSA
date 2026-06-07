package Interval;

import java.util.Arrays;

//problem, given array of intervals illustrating meetings
//we have to check a person can attend all meetings in given intervals

//if he can attend all meetings return true else return false

//simple logic, we have to verify that is any overlapping exists , if exists then it should return false. 

public class MeetingRooms{
    public static void main(String args[]){
        int [][] intervals = {{41,50},{0,30},{31,40}};
        boolean ans = findOverlaps(intervals);
        System.out.println(ans);
    }
    public static boolean findOverlaps(int[][] intervals){
        int i = 0;
        int n = intervals.length;

        //if given intervals is unsorted , definately we have to sort intervals first

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        while(i < n-1){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
            i++;
        }

        return true;
    }
}