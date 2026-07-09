package Arrays;
import java.util.Arrays;

//problem, given a integer array and target value
// so, we have remove the target val in array and return the remaining elements 
// at last , array must be rearranged in any order. ex [1,2,2,2,3,4,5] taregt = 2 -> {1,3,4,5,2,2,2}

public class RemoveElement {
    public static void main(String args[]){
        int nums [] = {0,1,2,2,3,0,4,2};
        int val = 2;
        int ans = remove(nums, val);
        System.out.println(ans);
    }
    static int remove(int [] nums, int val){
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
