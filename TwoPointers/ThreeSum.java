package TwoPointers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static void main(String args[]){
        int [] nums = {-1,0,1,2,-1,-4};
        List<int[]> result = findPairs(nums);
        for(int[] list : result){
            for(int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    public static List<int[]> findPairs(int[] nums){
        Arrays.sort(nums);

        int len = nums.length - 1;
        
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < len; i++){
            int left = i + 1;
            int right = len;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    list.add(new int[] {nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                }
                if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return list;
    }
}
