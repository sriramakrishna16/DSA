package MultidimensionalDP;

//problem , given three string s1 , s2,s3 
// so that we have to find that s1 and s2 can form s3 withouch changing the order

//if it forms, return true..

//ex : s1 -> ab s2 -> cd s3-> acbd then its true a b and c d are in same order 

public class InterleavingString {
    public static void main(String args[]){
        String s1 = "ab";
        String s2 = "cd";
        String s3 = "acbd";
        boolean ans = isInterLeave(s1,s2,s3);
        System.out.println(ans);
    }

    public static boolean isInterLeave(String s1, String s2, String s3){
        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length()){
            return false;
        }
        boolean [][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n; j++){
                if(i > 0 && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    dp[i][j] |= dp[i-1][j];  
                }
                if(j > 0 && s2.charAt(j-1)== s3.charAt(i+j-1)){
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
