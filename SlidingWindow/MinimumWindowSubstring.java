package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String [] args){ 
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String best = findBest(s,t);
        System.out.println(best);
    }

    public static String findBest(String s, String t){
        int [] fixedCount = new int [128];
        int [] count = new int [128];
        int left = 0;
        int dist = 0;
        int minLen = s.length()+1;
        int startIndex = -1;

        if (t.length() > s.length()) return "";
        
        for(int i=0;i<t.length();i++){
            fixedCount[t.charAt(i)]++;
        }

        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(fixedCount[ch] > 0 && count[ch]<fixedCount[ch]){
                dist++;
            }
            count[ch]++;
            while(dist==t.length()){
                if(minLen>right-left+1){
                    minLen= right-left+1;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                count[leftChar]--;

                if(fixedCount[leftChar] > 0 && count[leftChar]<fixedCount[leftChar]){
                    dist--;
                }

                left++;
            }
        }
        return startIndex==-1?"":s.substring(startIndex,startIndex+minLen);
    }

    // public static String findBest(String s , String t){
    //     if(s.length() < t.length()){
    //         return "";
    //     }

    //     HashMap<Character, Integer> targetString = new HashMap<>();

    //     for(char c : t.toCharArray()){
    //         targetString.put(c,targetString.getOrDefault(c,0)+1);
    //     }
    //     HashMap<Character, Integer> window = new HashMap<>();
    //     int left = 0;
    //     int formed = 0;
    //     int target = targetString.size();
    //     int minLen = Integer.MAX_VALUE;
    //     int start = 0;

    //     for(int right = 0; right < s.length(); right++){
    //         char c = s.charAt(right);
    //         window.put(c, window.getOrDefault(c, 0)+1);

    //         if(targetString.containsKey(c) && window.get(c) == targetString.get(c)){
    //             formed++;
    //         }
    
    //         while(formed == target){
    //             if(right - left + 1 < minLen){
    //                 minLen = right - left + 1;
    //                 start = left;
    //             }
    //             char leftChar = s.charAt(left);
    //             window.put(leftChar, window.get(leftChar) - 1);
    //             if(targetString.containsKey(leftChar) && window.get(leftChar) < targetString.get(leftChar)){
    //                 formed--;
    //             }
    //             left++;
    //         }
    //     }

    //     return minLen == Integer.MAX_VALUE?"":s.substring(start, start + minLen);
    // }
}

