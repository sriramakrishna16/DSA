package TwoPointers;
import java.util.Arrays;
import java.util.HashMap;

//problem , given an array of numbers
//we have to return the total pairs assuming if we found pair remove it from array so num cannot
// be used again...

public class MaxNoOfKSumPairs {
    public static void main(String args[]){
        int nums[] = {1,2,3,4};
        int k = 5;
        int ans = maxOperations(nums, k);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }

    public static int maxOperations(int [] nums, int k){
        //O(1) space solution and O(n log n) time

        // Arrays.sort(nums);
        // int i = 0;
        // int j = nums.length -1;
        // int count = 0;
        // while(i < j){
        //     int sum = nums[i] + nums[j];
        //     if(sum == k){
        //         i++;
        //         j--;
        //         count++;
        //     }else if(sum > k){
        //         j--;
        //     }else{
        //         i++;
        //     }
        // }
        // return count;

        //O(n) and O(n) solution
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num : nums){
            int compliment = k - num;
            if(map.containsKey(compliment) && map.get(compliment) > 0){
                count++;
                map.put(compliment, map.get(compliment) - 1);
                if(map.get(compliment) == 0){
                    map.remove(compliment);
                }
            }else{
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
