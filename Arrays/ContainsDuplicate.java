package Arrays;

import java.util.HashSet;


public class ContainsDuplicate {
    public static void main(String args[]){
        int nums[] = {1,2,3,1};
        boolean result = checkDuplicates(nums);
        System.out.println(result);
        
    }

    // public static boolean checkDuplicates(int [] nums){
    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     for(int x : nums){

    //         boolean duplicate = map.containsKey(x);

    //         if(duplicate){
    //             return true;
    //         }
    //         map.put(x, 1);
    //     }
    //     return false;
    // }

    //better solution is hashset because we dont need index to check duplicates

    public static boolean checkDuplicates(int [] nums){

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num:nums){
            if(hashSet.contains(num)){
                return false;
            }   
            hashSet.add(num);
        }

        return false;
    }
    
}
