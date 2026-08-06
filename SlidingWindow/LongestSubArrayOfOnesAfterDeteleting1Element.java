//problem , given an array of nums 0's and 1's..
// we have return the total no of max consecutive ones where one element must be deleted(not count either zero or one)

public class LongestSubArrayOfOnesAfterDeteleting1Element {
    public static void main(String [] args){
        int nums[] = {0,1,1,1,0,1,1,0,1};
        int ans = longestSubArray(nums);
        System.out.println(ans);
    }

    public static int longestSubArray(int[] nums){
        int j = 0;
        int count = 0;
        int flip = 0;
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                flip++;
            }
            count++;

            while(flip > 1){
                if(nums[j] == 0){
                    flip--;
                }
                count--;
                j++;
            }
            ans = Math.max(ans, count);
        }
        return ans-1;
    }
}
