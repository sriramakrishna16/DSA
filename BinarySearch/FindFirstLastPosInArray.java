package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//problem , given a sorted array with nums , and target
// we have to return the first and last index of the target.
// if not present return [-1,-1]

//after finding the mid == target , find the another occerences of left and right sides.

public class FindFirstLastPosInArray {
    public static void main(String args[]){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }
    
    public static int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);

        if (first == -1)
            return new int[]{-1, -1};

        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    public static int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
    public static int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;      // Search right side
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
