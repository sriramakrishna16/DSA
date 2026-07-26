package BinarySearch;

//problem , given an array of nums , so that we have to find the peak value
// simply array contains multiple sorted orders , so there will be multiple peaks 
// we must return any of one.

// solution using binary search we manipulate the mid by 
// if mid is greater than next mid -> right = mid (beacuse mid or less than mid may be peak)
// if mid is lesser than next mid - > left = mid + 1(because peak is definitely on right side).

public class FindPeakElement {
    public static void main(String args[]){
        int nums [] = {1,2,1,5,7,9,4,5};
        int idx = findPeak(nums);
        System.out.println(idx);
        System.out.println("peak elememt value : " + nums[idx]);
    }
    public static int findPeak(int [] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
