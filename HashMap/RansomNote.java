import java.util.*;

public class RansomNote{
    public static void main(String args[]){
        String ransomNote = "aa";
        String maganize = "aab";
        boolean ans = canConstruct(ransomNote, maganize);
        System.out.println(ans);
    }
    public static boolean canConstruct(String ransomNote, String maganize){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : maganize.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0){
                return false;
            }
            map.put(c,map.get(c) - 1);
        }
        return true;
    }
}