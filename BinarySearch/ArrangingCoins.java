//we have to arrange the given n coins into staircase model using rows
// and return the successfully completed rows.

//ex : if n is 5 , 1 11 111(x) , the third row is not possible , so only 2 rows.

public class ArrangingCoins {
    public static void main(String [] args){
        int n = 5;
        int ans = arrangeCoins(n);
        System.out.println(ans);
    }
    public static int arrangeCoins(int n){
        long left = 0;
        long right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coins = mid * (mid + 1) / 2;
            if (coins <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }
}
