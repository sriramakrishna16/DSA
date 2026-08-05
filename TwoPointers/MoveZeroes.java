package TwoPointers;
import java.util.Arrays;

//problem , move zeroes to the of the array

public class MoveZeroes {
    public static void main(String [] args){
        int [] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int [] nums){
        // int i = 0;
        // while(i < nums.length){
        //     while(i < nums.length && nums[i] != 0){
        //         i++;
        //     }
        //     int j = i;
        //     while(j < nums.length-1 && nums[j] == 0){
        //         j++;
        //     }
        //     if (j == nums.length) {
        //         break;
        //     }
        //     int temp = nums[i];
        //     nums[i] = nums[j];
        //     nums[j] = temp;
        //     i++;
        // }

        //more precise one
        int i = 0;
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}

