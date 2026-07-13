package LeetcodeEasy;
import java.util.Arrays;

public class MinimumNumberGame {
    public static void main(String args[]){
        int nums [] = {5,4,2,3};
        int[] ans = game(nums);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] game(int [] nums){
        Arrays.sort(nums); 
        int [] arr = new int[nums.length];
        int i = 0; //1
        while(i < nums.length - 1){
            arr[i] = nums[i+1];
            arr[i+1] = nums[i];
            i += 2;
        }
        return arr;
    }
}
