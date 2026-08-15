package DynamicProgramming;

public class Tribonacci {
    public static void main(String [] args){
        int n = 3;
        int ans = findTribonacci(n);
        System.out.println(ans);
    }
    // 0 1 1 2 4 7 13 24...
    public static int findTribonacci(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        // int first = 0;
        // int second = 1;
        // int third = 1;
        // for(int i = 3 ; i <= n ; i++){
        //     int next = first + second + third;
        //     first = second;
        //     second = third;
        //     third = next;
        // }
        // return third;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
