public class BestTimeToBuyAndSell2 {
    public static void main(String args[]){
        int stocks [] = {1,2,3,4,5};
        int ans = findProfit(stocks);
        System.out.println(ans);
    }
    public static int findProfit(int [] stocks){
        int maxProfit = 0;
        int entry = Integer.MAX_VALUE;
        for(int stock : stocks){
            if(stock < entry){
                entry = stock;
            }
            int profit = stock - entry;
            if(profit > 0){
                maxProfit += profit;
                entry = stock; 
            }
        }
        return maxProfit;

        // int maxProfit = 0;
        // for(int i = 1; i<prices.length; i++){
        //     if(prices[i] > prices[i - 1]){
        //         maxProfit += prices[i] - prices[i - 1];
        //     }
        // }
        // return maxProfit;
    }
}
