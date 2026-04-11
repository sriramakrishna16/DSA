//problem contigous increasing array , count of subarrays in which sum equal to k

package SlidingWindow;

public class SubArraySumEqualsK{
    public static void main(String args[]){
        int [] nums = {1,2,3,4,5,9};
        int k = 9;
        int ans = findSubArrayEqualsK(nums, k);
        System.out.println(ans);
    }

    public static int findSubArrayEqualsK(int[] nums, int k){
        int left = 0;
        int count = 0;
        int right = 0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];
            while(sum > k && left <= right){
                sum -= nums[left];
                left++;
            }
            if(sum == k ){
                count++;
            }
            right++;
        }
        return count;
    }
}