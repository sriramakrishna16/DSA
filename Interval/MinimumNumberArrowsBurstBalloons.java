package Interval;
import java.util.Arrays;

public class MinimumNumberArrowsBurstBalloons {
    public static void main(String args[]){
        int nums[][] = {{10,16},{2,8},{1,6},{7,12}};
        long arrows = findMinArrows(nums);
        System.out.println(arrows);
    }
    public static long findMinArrows(int [][] nums){
        Arrays.sort(nums,(a,b)-> Long.compare((long)a[1],(long)b[1]));
        int arrows = 1;
        long arrowPos = nums[0][1];
        for(int i = 1; i<nums.length; i++){
            if(nums[i][0] > arrowPos){
                arrows++;
                arrowPos = nums[i][1];
            }
        }
        return arrows;

    }
}
