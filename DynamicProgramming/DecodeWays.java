package DynamicProgramming;

//problem given a code , that is encoded as a secret message ,
//  find how many ways of possible decoded messages

public class DecodeWays {
    public static void main(String args[]){
        String s = "66656";

        int ans = findWays(s);
        System.out.println(ans);

    }
    public static int findWays(String s){

        int len = s.length();

        if(len == 1 && s.charAt(0) != '0'){
            return 1;
        } 

        if(len == 0 || s.charAt(0) == '0') return 0;

        int [] dp = new int [len + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i <= len ; i++){
            int curr = s.charAt(i-1);
            int prev = s.charAt(i-2);

            if(curr != '0'){
                dp[i] += dp[i-1]; 
            }

            int num = (prev - '0') * 10 + (curr - '0');
            if(10 <= num && num <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[len];

    }
}
