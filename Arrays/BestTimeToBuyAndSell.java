package Arrays;

public class BestTimeToBuyAndSell {
    public static void main(String [] args){
        int [] stockPrices = {7,1,5,3,6,19,4};
        int profit = findBestProfit(stockPrices);
        System.out.println(profit);
    }

    public static int findBestProfit(int[] prices){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for(int price : prices){

            if(price<minPrice){
                minPrice = price;
            }

            int profit = price-minPrice;

            // maxProfit = Math.max(maxProfit,profit);
            if(profit>maxProfit){
                maxProfit = profit;
            }

        }

        return maxProfit;
    }
}


