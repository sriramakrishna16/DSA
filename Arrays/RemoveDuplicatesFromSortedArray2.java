package Arrays;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String args[]){
        int nums[] = {0,0,1,1,1,1,2,3,3};
        int ans = remove(nums);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }
    public static int remove(int[] nums){
        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
