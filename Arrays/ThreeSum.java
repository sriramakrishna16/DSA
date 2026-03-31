package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String [] args){
    int nums[] = {-1,0,1,2,-1,-4};
    List<List<Integer>> result = findSum(nums);
    for(List<Integer> list: result){
        System.out.println(list);
    }
    }

    //brute force

    // public static List<int[]> findSum(int[] nums){
    //     Arrays.sort(nums);
    //     Set<String> set = new HashSet<>();
    //     ArrayList<int[]> list = new ArrayList<>();
    //     for (int i=0;i<nums.length-2;i++){
    //         for (int j=i+1;j<nums.length-1;j++){
    //             for (int k=j+1;k<nums.length;k++){
    //                 int sum = 0;
    //                 if(nums[i] + nums[j] + nums [k] == sum){

    //                     String key = nums[i] + "," + nums[j] + "," + nums[k];
    //                     if(!set.contains(key)){
    //                         set.add(key);
    //                         list.add(new int[]{nums[i],nums[j],nums[k]});
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return list;
    // }

    //optimised version using two pointers
    //steps it must be sorted , if target is bigger , left ++ , if smaller right --
    //in this way we can find pairs for our target.

    public static List<List<Integer>> findSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]>0){
                break;
            }

            int left = i+1;
            int right = nums.length - 1;

            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left + 1]){
                        left ++;
                    }
                    while(left<right && nums[right] == nums[right-1]){
                        right --;
                    }
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left ++;
                }
                else if(sum > 0){
                    right --;
                }
            }
        }
        return result;
    }

}
