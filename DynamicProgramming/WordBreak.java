package DynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String args[]){
        String s = "leetcode";
        List<String> list = Arrays.asList("leet","code");
        boolean result = wordBreak(s,list);
        System.out.println(result);
    }
    public static boolean wordBreak(String s, List<String> list){

        int max = 0;
        for(String word : list){
            max = Math.max(word.length(),max);
        }

        Set<String> set = new HashSet<>(list);
        int len = s.length();
        boolean [] dp = new boolean[len + 1];

        dp[0] = true;

        for(int i = 1; i<=len; i++){
            for(int j = (Math.max(0,i-max)); j<i; j++){
                String current = s.substring(j, i);
                if(dp[j] && set.contains(current)){
                    dp[i]= true;
                    break;
                }else{
                    dp[i] = false;
                }
            }
        }

        return dp[len];

    }
}
