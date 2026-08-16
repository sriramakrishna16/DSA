package DynamicProgramming;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String [] args){
        int [] prices = {1,3,2,8,4,9};
        int fee = 2;
        int ans = maxProfit(prices,fee);
        System.out.println(ans);
    }
    public static int maxProfit(int [] prices , int fee){
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newCash = Math.max(cash, hold + prices[i] - fee);
            int newHold = Math.max(hold, cash - prices[i]);
            cash = newCash;
            hold = newHold;
        }
        return cash;
    }
}
