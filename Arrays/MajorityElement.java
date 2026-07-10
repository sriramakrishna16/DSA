package Arrays;
import java.util.Arrays;

//problem , return majority element 
//majority element mean it must repeats (n / 2) times in array 
//ex array len is 9 then element repeated 5 times considered as majority element.

public class MajorityElement {
    public static void main(String args[]){
        int nums[] = {2,2,1,1,1,2,2};
        int ans = majorityElement(nums);
        System.out.println(ans);
    }
    public static int majorityElement(int [] nums){
        // Arrays.sort(nums);
        // return nums[nums.length /2];

        //Boyer moore voting algorithm

        // int candidate = 0;
        // int count = 0;

        // for (int num : nums) {
        //     if (count == 0) {
        //         candidate = num;
        //     }

        //     if (num == candidate) {
        //         count++;
        //     } else {
        //         count--;
        //     }
        // }

        // return candidate;

        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i<nums.length-1; i++){
            if(nums[i] == candidate){
                count++;
            }
            if(nums[i] != candidate){
                count--;
                if(count == 0 && nums[i+1] != candidate){
                    candidate = nums[i+1];
                }
            }
        }
        return candidate;
    }
}
