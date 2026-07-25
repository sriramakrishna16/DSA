import java.util.*;
public class Combinations{
    public static void main(String args[]){
        int n = 4;
        int k = 2;
        List<List<Integer>> ans = findCombinations(n,k);
        System.out.println(ans); 
    }
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> findCombinations(int n , int k){
        if(k == 0) return ans;
        backtrack(n,k,1, new ArrayList<>());
        return ans;
    }
    public static void backtrack(int n , int k , int start, List<Integer> curr){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start ; i <= n ; i++){
            curr.add(i);
            backtrack(n,k,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}