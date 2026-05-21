package BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String args[]){
        int [] nums = {5,6,7,0,1,2};
        int target = 6;
        int targetIndex = findIndex(nums, target);
        System.out.println(targetIndex);
    }
    public static int findIndex(int[] nums, int target){
        int first = 0;
        int last = nums.length - 1;
        int ans = 0;
        while(first <= last){
            int mid = (first + last) / 2;
            if(nums[mid] == target){
                ans = mid;
            }
            if(nums[mid] > nums[first] ){
                if(nums[first] <= target && target < nums[mid]){
                    last = mid - 1; 
                }else{
                    first = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[last]){
                    first = mid + 1;
                }else{
                    last = mid - 1;
                }
            }
        }
        return ans;
        }
}
