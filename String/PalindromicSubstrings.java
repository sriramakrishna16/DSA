public class PalindromicSubstrings {
     public static void main(String[] args) {

        System.out.println(countSubstrings("abc"));   // 3
        System.out.println(countSubstrings("aaa"));   // 6
        System.out.println(countSubstrings("abba"));  // 6
        System.out.println(countSubstrings("racecar"));//10
     }

    public static int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindromes
            count += expand(s, i, i);

            // Even length palindromes
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private static int expand(String s, int left, int right) {

        int count = 0;

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }

        return count;
    }

   
}

