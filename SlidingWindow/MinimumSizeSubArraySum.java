public class MinimumSizeSubArraySum {
    public static void main(String args[]){
        int nums [] = {2,3,1,2,4,3};
        int target = 7;
        int ans = min(nums, target);
        System.out.println(ans);
    }
    public static int min(int[] nums, int target){
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while(right<nums.length){
            sum += nums[right];
            while(sum >= target){
                len = Math.min(len, right - left + 1);
                sum -= nums[left];
                left++;
            } 
            right++;
        }
        return len == Integer.MAX_VALUE? 0 : len;
    }
}
