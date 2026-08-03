package MultidimensionalDP;

public class BestTimeToBuyAndSellStocks4 {
    public static void main(String args[]){
        int prices [] = {3,2,6,5,0,3};
        int k = 2;
        int ans = maxProfit(prices, k);
        System.out.println(ans);
    }

    public static int maxProfit(int [] prices , int k){
        if(prices.length == 0 || k == 0){
            return 0;
        }

        int buy[] = new int [k+1];
        int sell[] = new int[k+1];

        for(int i = 1 ; i <= k ; i++){
            buy[i] = Integer.MIN_VALUE;
        }

        for(int price : prices){
            for(int i = 1 ; i <= k ; i++){
                buy[i] = Math.max(buy[i] , (sell[i-1] - price));
                sell[i] = Math.max(sell[i] , buy[i] + price);
            }
        }

        return sell[k];
    }
}
