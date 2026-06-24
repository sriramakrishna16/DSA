//problem , given string so that we have to return longest valid substring that is palindrome
//we use center approach for both even and odd palindromes 
//and updates left and right positions based on longest substring

public class ValidPalindromicSubstring {
    static int start;
    static int maxLen;
    /* public static void main(String[] args) {
        String s = "babad";
        String longS = findLongPalindrome(s);
        System.out.println(longS);
    }
    public static String findLongPalindrome(String s){
        String sb = "";

        int big = 0;

        for(int i = 0 ; i < s.length() ; i++){
            String pal1 = expand(s, i , i);
            String pal2 = expand(s, i, i+1);
            if(pal1.length() > big){
                big = pal1.length();
                sb = pal1;
            }
            if(pal2.length() > big){
                big = pal2.length();
                sb = pal2;
            }
        }
        return sb.toString();
    }
    public static String expand(String s, int left , int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    } */


    public static void main(String[] args) {
        String s = "abcdedbabad";
        String longS = findLongPalindrome(s);
        System.out.println(longS);
    }
    public static String findLongPalindrome(String s){
        for(int i = 0 ; i < s.length() ; i++){
            //for odd palindromes
            expand(s, i , i);
            //for even palindromes
            expand(s, i, i+1);
        }
        return s.substring(start, start + maxLen);
    }
    public static void expand(String s, int left , int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int len = right - left - 1;

        //updating left and right positions if found longest valid substring
        if(len > maxLen){
            maxLen = len;
            start = left + 1;
        }
    }
}