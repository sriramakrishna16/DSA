//problem , given an array of 0's and 1's  and an integer k
// we have to return max len of consecutive 1's with using k flips 0-1.

public class MaximumConsecutiveOnes3{
    public static void main(String [] args){
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int ans = longestOnes(nums,k);
        System.out.println(ans);
    }
    private static int longestOnes(int[] nums, int k){
        // int max = 0;
        // int j = 0;
        // int flips = 0;
        // int count = 0;
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(nums[i] == 1){ //5
        //         count++;
        //     }else if(flips < k){
        //         flips++;
        //         count++;
        //     }else{
        //         if(nums[j] == 0){
        //             flips--;
        //         }
        //         count--;
        //         j++;
        //         i--;
        //     }
        //     max = Math.max(max, count);
        // }
        // return max;

        //more precised one
        int left = 0;
        int zeroes = 0;
        int max = 0;
        for(int right = 0 ; right < nums.length; right++){
            if(nums[right] == 0){
                zeroes++;
            }
            while(zeroes > k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}