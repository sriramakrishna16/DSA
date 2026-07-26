package BinarySearch;

public class SearchInsertPosition {
    public static void main(String args[]){
        int nums [] = {1,3,5,6};
        int target = 4;
        int idx = findIndex(nums, target);
        System.out.println(idx);
    }
    public static int findIndex(int nums [], int target){
        // int idx = find(0,nums.length-1,nums,target);
        // return idx;

        //without recursion
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    // private static int find(int left , int right , int [] nums , int target){
    //     if(left > right){
    //         return left;
    //     }
    //     int ans;
    //     int mid = left + (right - left)/2;
    //     if(nums[mid] == target){
    //         return mid;
    //     }else if(nums[mid] < target){
    //         ans = find(mid + 1, right, nums, target);
    //     }else{
    //         ans = find(left , mid - 1 , nums, target);
    //     }
    //     return ans;
    // }
}
