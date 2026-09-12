package Z_LeetCode_Contest.Biweekly191;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// same as series 1 problem with little changes that is 
// specail integer if atleast 3 times occur , so more than 3 also eligible
// and all occurences are equally spaced,
// if all occurrences of x are at indices i1 < i2 < ... < im, 
// then i2 - i1 = i3 - i2 = ... = im - im-1. 

public class CountValuesWithEquallySpacedOccurence2 {
    public static void main(String[] args){
        int [] nums = {8,8,8,8};
        int totalSpecialIntegers = countSpecialIntegers(nums);
        System.out.println(totalSpecialIntegers);
    }
    public static int countSpecialIntegers(int[] nums){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int specialCount = 0;
        for(List<Integer> indices : map.values()){
            int prev = 0;
            int count = 0;
            boolean x = false;
            for(int i = 1; i < indices.size() && indices.size() >= 3 ; i++){
                int diff = indices.get(i)- indices.get(i-1);
                if(count == 0){
                    prev = diff;
                    x = true;
                    count++;
                }
                else if(diff != prev){
                    x = false;
                    break;
                }
            }
            if(x){
                specialCount++;
            }
        }
        return specialCount;
    }
}
