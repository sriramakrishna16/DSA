package LeetcodeEasy;

import java.util.HashMap;

public class FirstUnqChar {
    public static void main(String args[]){
        String s = "aabbc";
        int index = findUnq(s);
        System.out.println(index);
    }
    public static int findUnq(String s){
        // int count = Integer.MAX_VALUE;
        // HashMap<Character, Integer> map = new HashMap<>();
        // for(char ch : s.toCharArray()){
        //     map.put(ch, map.getOrDefault(ch,0)+1);
        // }
        // for(int i = 0; i < s.length(); i++){
        //     if(map.get(s.charAt(i)) == 1){
        //         return i;
        //     }
        // }
        // return -1;

        //frequency method

        int [] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0; i<s.length(); i++){
            if(freq[s.charAt(i)- 'a'] == 1) return i;
        }
        return -1;
    }
}
