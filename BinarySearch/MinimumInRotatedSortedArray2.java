package BinarySearch;

public class MinimumInRotatedSortedArray2 {
    public static void main(String [] args){
        int [] nums = {2,2,2,0,1};
        int ans = findMin(nums);
        System.out.println(ans);
    }
    public static int findMin(int [] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                right--;
            }
        }
        return nums[left];
    }
}
