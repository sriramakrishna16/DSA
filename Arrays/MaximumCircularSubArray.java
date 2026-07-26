package Arrays;

public class MaximumCircularSubArray {
    public static void main(String args[]){
        int [] nums = {5,-3,5};
        int ans = findMax(nums);
        System.out.println(ans);
    }
    public static int findMax(int [] nums){
        int totalSum = 0;
        int currentSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length ; i++){
            totalSum += nums[i];
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(currentSum, maxSum);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum , totalSum - minSum);
    }
}
