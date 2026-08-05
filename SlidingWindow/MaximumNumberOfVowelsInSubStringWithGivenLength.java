package SlidingWindow;

//problem , given a string and length k 
// so we have the max no of vowels in string s within length k.

public class MaximumNumberOfVowelsInSubStringWithGivenLength {
    public static void main(String [] args){
        String s = "leetcode";
        int k = 3;
        int ans = maxVowels(s, k);
        System.out.println(ans);
    }

    private static int maxVowels(String s, int k){
        int ans = 0;
        int count = 0;
        int j = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                count++;
            }
            if(i - j + 1 == k){
                ans = Math.max(ans, count);
                if(ans == k) return ans;
                if(isVowel(s.charAt(j))){
                    count--;
                }
                j++;
            }
        }
        return ans;
    }
    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
