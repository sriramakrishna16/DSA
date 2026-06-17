package String;

//problem , given two strings and we have to find the two strings have same char or diff.
//solution used , a simple array with size 26 
//first string increases the array count
//second string decreases the array count
//at last ,if two strings same,full array values becomes zero , else its false

public class ValidAnagram {
    public static void main(String arg[]){
        String s = "anagram";
        String t = "nagaram";
        boolean ans = findAnagram(s,t);
        System.out.println(ans);
    }
    public static boolean findAnagram(String s, String t){
        //if both string lengths not same , return false
        if(s.length() != t.length()){
            return false;
        }

        int [] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int val : arr){
            if(val != 0){
                return false;
            }
        }

        return true;
    }
}
