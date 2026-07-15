package TwoPointers;
import java.util.Arrays;

public class TwoSum2 {
    public static void main(String args[]){
        int [] nums = {2,8,11,15};
        int target = 9;
        int [] ans = findIndex(nums, target);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] findIndex(int [] nums , int target){
        int i = 0, j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }
            if(sum > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{};
    }
}
