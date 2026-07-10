public class FirstPalindrome {
    public static void main(String args[]){
        String [] s = {"abc","car","ada","racecar","cool"};
        String ans = findPalindrome(s);
        System.out.println(ans);
    }
    public static String findPalindrome(String [] s){
        for(String str : s){
            if(palindrome(str,0,str.length()-1)){
                return str;
                }
            } 
        return "";
    }
    public static boolean palindrome(String s,int i , int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}