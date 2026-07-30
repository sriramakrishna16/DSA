package MultidimensionalDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Traingle {
    public static void main(String args[]){
        List<List<Integer>> traingle = new ArrayList<>();
        traingle.add(new ArrayList<>(Arrays.asList(2)));
        traingle.add(new ArrayList<>(Arrays.asList(3,4)));
        traingle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        traingle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        
        int min = minimum(traingle);
        System.out.println(min);
    }
    public static int minimum(List<List<Integer>> traingle){
        int n = traingle.size();
        int dp [] = new int[traingle.get(n-1).size()];
        for(int i = 0 ; i < traingle.get(n-1).size() ; i++){
            dp[i] = traingle.get(n - 1).get(i);
        }
        for(int i = n - 2 ; i >= 0 ; i--){
            List<Integer> curr = traingle.get(i);
            for(int j = 0 ; j < curr.size() ; j++){
                dp[j] = curr.get(j) + Math.min(dp[j], dp[j+1]);
            }
        }        

        return dp[0];
    }
}
