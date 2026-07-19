package LeetcodeEasy;

//pangram : must contain every letter of english alphabets atleast once.
public class Pangram {
    public static void main(String args[]){
        String s = "thequickbrownfoxjumpsoverthelazydog";
        boolean ans = pangram(s);
        System.out.println(ans);
    }
    public static boolean pangram(String s){
        if(s.length() < 26){
            return false;
        }
        int [] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0 ; i < 26; i++){
            if(freq[i] == 0){
                return false;
            }
        }
        return true;
    }
}
