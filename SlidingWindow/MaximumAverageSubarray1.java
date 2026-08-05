package SlidingWindow;

//problem, given an array of nums..
// we have to return max subarray of k nums and avg.

public class MaximumAverageSubarray1 {
    public static void main(String [] args){
        int nums[] = {1,12,-5,-6,50,3};
        int k = 4;
        double ans = findMaxAvg(nums, k);
        System.out.println(ans);
    }
    public static double findMaxAvg(int[] nums , int k){
        // if(nums.length == 1) return (double)nums[0];
        // double ans = Double.NEGATIVE_INFINITY;
        // int i = 0;
        // double max = 0;
        // int count = 0;
        // for(int j = 0 ; j < nums.length; j++){
        //     max += nums[j];
        //     count++;
        //     if (count == k) {
        //         ans = Math.max(ans, max / k);
        //         max -= nums[i];
        //         i++;
        //         count--;
        //     }
        // }
        // return ans;

        //another solution
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];
            windowSum -= nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}
