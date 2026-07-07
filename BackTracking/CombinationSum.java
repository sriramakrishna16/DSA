package BackTracking;
import java.util.List;
import java.util.ArrayList;


//problem , given an array of integer values
//so we can use value in array for multiple times to reach target
// and we have to return the list of all possibilities of array values to reach target.

public class CombinationSum {
    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String args[]){
        int [] nums = {2,3,6,7};
        int target = 8;
        helper(nums, 0 , target, new ArrayList<>());
        System.out.println(ans);
    }
    public static void helper(int [] nums, int i, int target, List<Integer> current){
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || i == nums.length){
            return;
        }

        current.add(nums[i]);
        helper(nums, i, target - nums[i], current);

        current.remove(current.size()-1);

        helper(nums, i + 1, target, current);
    }
}
