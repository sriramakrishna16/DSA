public class MaximumSubArray {
    public static void main(String [] args){
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSum(nums);
        System.out.println(result);
    }

    //Brute Force , for every i , we find all sums to end by targetting maxSum only for each subarray
    //after i 1 passes , next i 2 , we keep update maxSUm if high found
    //till it do n*n times to get all that is o(n^2) 

    // public static int maxSum(int[] nums){
    //     int maxSum = Integer.MIN_VALUE;

    //     for(int i=0;i<nums.length;i++){
    //         int sum = 0;     //for every new sub array we are resetting the sum
    //         for(int j=i;j<nums.length;j++){
    //             sum += nums[j];
    //             maxSum = Math.max(maxSum,sum);
    //         }
    //     }
    //     return maxSum;
    // }


    //optimised approach
    //in brutee force we travel all the elements , most of the elemenet's sums are not needed to do.
    //so we use kadanes algorithm:
        //simply based on sum , itdecides should i continue to go forward or start new 
        //ex: if negatve sum raises , takes new and continues
        //in one loop that is O(n) , we can find the sub array sum

    public static int maxSum(int[] nums){
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 0;i<nums.length;i++){
            // currentSum = Math.max(nums[i], currentSum+nums[i]);
            // maxSum = Math.max(maxSum, currentSum);

            //we can also do like this 
            currentSum += nums[i]; //keep summing for every loop
            if(currentSum < 0){  //if currentsum becomes - , we dont need reset it 
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);

            

        }


        return maxSum;
    }

}
