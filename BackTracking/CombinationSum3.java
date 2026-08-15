import java.util.ArrayList;
import java.util.List;

//given k represents total no of digits and n represnts the target
// we have to find the all combinations of k digits that sums up to equal for n
// and use single digit only once , example -> k = 3, n = 7 -> {1,2,4} only one combination

public class COmbinationSum3 {
    public static void main(String [] args){
        int k = 3;
        int n = 7;
        List<List<Integer>> ans = combinationSum3(k,n);
        System.out.println(ans);
    }
    public static List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(k,n, 1,new ArrayList<>(), ans);
        return ans;
    }
    public static void backtrack(int k , int n, int start, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == k){
            if(n == 0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i = start; i <=9; i++){
            if(i > n){
                break;
            }
            curr.add(i);
            backtrack(k, n-i, i+1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
