package SlidingWindow;


//problem return true if permutation found in string 2
public class PermutationInString {
    public static void main(String args[]){
       String s1 = "ab";
       String s2 = "nightbo";
       boolean result = findPermutation(s1, s2);
       System.out.println(result);
    }
    public static boolean findPermutation(String s1, String s2){
        int [] s1Count = new int [26];
        int [] window = new int [26];

        for(int i = 0; i< s1.length(); i++){
            s1Count[s1.charAt(i)-'a']++;
            window[s2.charAt(i)- 'a']++; //first window
        }

        if(matches(s1Count, window)) return true;

        for(int i = s1.length();i < s2.length(); i++){
            window[s2.charAt(i)-'a']++;
            window[s2.charAt(i - s1.length()) - 'a']--;

            if(matches(s1Count, window)) return true;
        }
        return false;
    }

    public static boolean matches(int[] a, int[] b){
        for(int i = 0 ; i< 26 ; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
