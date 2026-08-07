import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//problem , given two string where we have to return true if they are close by following two operations
// one is swap any two existing charcaters like abc - acb -> swap bc to cb and return true
// second one is transform every occurence of one existing char into another existing char like aab -> bba

public class DetermineIfStringsAreClose {
    public static void main(String [] args){
        String word1 = "abc";
        String word2 = "bca";
        boolean ans = isClose(word1,word2);
        System.out.println(ans);
    }
    public static boolean isClose(String word1, String word2){
        // HashMap<Character, Integer> map1 = new HashMap<>();
        // HashMap<Character, Integer> map2 = new HashMap<>();
        // for(int i = 0 ; i < word1.length() ; i++){
        //     map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i),0)+1);
        // }
        // for(int i = 0 ; i < word2.length() ; i++){
        //     map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i),0)+1);
        // }
        // if (!map1.keySet().equals(map2.keySet())) {
        //     return false;
        // }
        // // List<Integer> list1 = new ArrayList<>(map1.values());
        // // List<Integer> list2 = new ArrayList<>(map2.values());

        // // Collections.sort(list1);
        // // Collections.sort(list2);
        // for(char c : map1.keySet()){
        //     int val = map1.get(c);
        //     if(!map2.containsValue(val)){
        //         return false;
        //     }
        //     map2.values().remove(val);
        // }

        // return true;

        if(word1.length()!=word2.length())
        {
            return false;
        }

        int []freq1 = new int[26];
        int []freq2 = new int[26];

        for(char c : word1.toCharArray())
        {
            freq1[c-'a']++;
        }
        for(char c : word2.toCharArray())
        {
            freq2[c-'a']++;
        }

        for(int i=0;i<26;i++)
        {
            if((freq1[i]>0 && freq2[i]==0)|| (freq1[i]==0 && freq2[i]>0)) return false;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1,freq2);
    }
}
