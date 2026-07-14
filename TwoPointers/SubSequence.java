package TwoPointers;

public class SubSequence {
    public static void main(String args[]){
        String s = "abc";
        String t = "ahbgd";
        boolean ans = findSubsequence(s,t);
        System.out.println(ans);
    }
    public static boolean findSubsequence(String s , String t){
        if(s.length() > t.length()) return false;

        int i = 0,j=0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
