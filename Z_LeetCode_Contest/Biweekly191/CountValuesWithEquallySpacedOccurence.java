package Z_LeetCode_Contest.Biweekly191;
// problem , given an array of nums, an integer x is special
//  if x appeared exactly three times and all three occurence of x 
// are equally spaced in nums that mean occurence of x are at indices
// i1 < i2 < i3... then i2-i1 = i3-i2

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountValuesWithEquallySpacedOccurence {
    public static void main(String [] args){
        int [] nums = {1,8,1,5,1,5,8,5};
        int totalSpecialIntegers = countSpecialIntegers(nums);
        System.out.println(totalSpecialIntegers);
    }
    public static int countSpecialIntegers(int[] nums){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int specialCount = 0;

        for(List<Integer> indices : map.values()){
            if(indices.size() == 3){
                int i1 = indices.get(0);
                int i2 = indices.get(1);
                int i3 = indices.get(2);
                if(i2 - i1 == i3 - i2){
                    specialCount++;
                }
            }
        }

        return specialCount;
    }
}
