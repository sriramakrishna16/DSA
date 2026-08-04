package Arrays;
import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestCandies {
    public static void main(String args[]){
        int [] candies = {4,2,1,1,2};
        int extraCandies = 1;
        List<Boolean> ans = kidsWithCandies(candies,extraCandies);
        for(boolean a : ans){
            System.out.print(a + " ");
        }
    }

    public static List<Boolean> kidsWithCandies(int [] candies, int extra){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < candies.length ; i++){
            max = Math.max(max, candies[i]);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0 ; i < candies.length; i++){
            if(candies[i] + extra >= max){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}
