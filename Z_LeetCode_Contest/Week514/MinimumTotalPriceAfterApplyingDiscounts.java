import java.util.Arrays;
public class MinimumTotalPriceAfterApplyingDiscounts{
    public static void main(String args[]){
        int [] prices = {10,30,21};
        int [] discounts = {50,60};
        double ans = minPrice(prices, discounts);
        System.out.println(ans);
    }
    public static double minPrice(int[] prices, int[] discounts){
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i = prices.length - 1;
        int j = discounts.length - 1;
        double ans = 0;
        while(j >= 0 && i >= 0){
            ans += (double)prices[i] * (100 - discounts[j])/100;
            i--;
            j--;
        }
        while(i >= 0){
            ans += prices[i];
            i--;
        }
        return ans;
    }
}