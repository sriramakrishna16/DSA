package Z_LeetCode_Contest.Week509;

//problem , given two strings we have to check s1 is a subsequence of s2 
// and another thing is we can replace one char in s1 to make it subsequence

//solution is simple we skip one char comparision and finds remaining are subsequence or not

//i have used two approaches 1 is prefix and suffix 
        //in prefix and suffix we build arrays with match indexes
        // and at final we find that there is atleast single gap or not by comparing p and s.
    //2 is -> by state machine / greedy dp which is simple algorith , just by using 
    // exact and incrementstate we find the s is subsequence of t or not by skipping only one 
    //char using incrementState (if not match iS = eS + 1 , and this follows entire code)

public class P2_SubsequenceAfterOneReplacement {
    public static void main(String args[]){
        String s1 = "abd";
        String s2 = "acd";
        boolean ans = findSubSeq(s1,s2);
        System.out.println(ans);
    }
    /* public static boolean findSubSeq(String s , String t){
        int m = s.length();
        int n = t.length();

        if(m > n){
            return false;
        }

        int [] pref = new int[m];

        int tp = 0;
        for(int i = 0 ; i < m ; i++){
            while(tp < n && t.charAt(tp) != s.charAt(i)){
                tp++;
            }
            if(tp < n){
                pref[i] = tp;
                tp++;
            }else{
                pref[i] = n;
            }
        }

        if(pref[m - 1] < n){
            return true;
        }

        int ts = n-1;
        int [] suff = new int [m];

        for(int i = m-1; i>= 0 ; i--){
            while(ts >= 0 && s.charAt(i) != t.charAt(ts)){
                ts--;
            }
            if(ts >= 0){
                suff[i] = ts;
                ts--;
            }else{
                suff[i] = -1;
            }
        }

        for(int i=0; i<m; i++){
            int leftBound = (i == 0)? -1:pref[i-1];
            int rightBound = (i == m-1)?n:suff[i+1];
            if(leftBound+1<rightBound){
                return true;
            }
        }
        return false;
    } */
    public static boolean findSubSeq(String s , String t){
        int m = s.length(), n = t.length();

        int incrementState = 0;
        int exactMatch = 0;

        for(int i = 0 ; i < n ; i++){
            int ch = t.charAt(i);

            if(incrementState < s.length() && ch == s.charAt(incrementState)){
                incrementState++;
            }

            incrementState = Math.max(incrementState, Math.min(s.length(),exactMatch + 1));

            if(exactMatch < s.length() && s.charAt(exactMatch) == ch){
                exactMatch++;
            }

            if(incrementState == s.length()){
                return true;
            }

        }
        return false;
    }
}
