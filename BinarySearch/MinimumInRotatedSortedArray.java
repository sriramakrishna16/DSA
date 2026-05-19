package BinarySearch;

public class MinimumInRotatedSortedArray {

    //by using binarysearch finding the min value in the rotated array
    public static void main(String args[]){
        int [] nums = {3,4,5,1,2};
        int ans = findMin(nums);
        System.out.println(ans);
    }
    public static int findMin(int[] nums){
        int first = 0;
        int last = nums.length - 1;
        while(first<last){
            int mid = (first + last) / 2;
            if(nums[mid]>nums[last]){ 
                first = mid + 1;
            }else{
                last = mid;
            }
        }

        return nums[first];

    }
}
