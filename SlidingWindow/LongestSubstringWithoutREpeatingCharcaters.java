package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutREpeatingCharcaters{
    public static void main(String[] args){
        String string = "abba";
        int max = findMax(string);
        System.out.println(max);
    }

    //brute force

    //a,b,c,a,b,c,b,b
    // public static int findMax(String s){
    //     int m = s.length();
    //     int max = 0;
    //     for(int i =0;i<m;i++){
    //         HashSet<Character> set = new HashSet<>();
    //         for(int j=i;j<m;j++){
    //             if(set.contains(s.charAt(j))){
    //                 break;
    //             }else{
    //                 set.add(s.charAt(j));
                    
    //             }
    //             max = Math.max(max,set.size());
    //         }
    //     }
    //     return max;
       
    // }

    //using hash map and sliding windoe
    public static int findMax(String s){
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<s.length();right++){
            Character c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(left,map.get(c) + 1);
            }
            map.put(c,right);
            max = Math.max(max, right- left + 1);
        }

        return max;
    }


}