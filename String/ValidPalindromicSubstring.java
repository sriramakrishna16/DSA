public class ValidPalindromicSubstring {
    public static void main(String[] args) {

        String[] testCases = {
                "babad",
                "cbbd",
                "racecar",
                "forgeeksskeegfor",
                "aaaa",
                "abcde",
                "abba",
                "banana"
        };

        for (String s : testCases) {
            System.out.println("Input  : " + s);
            System.out.println("Output : " + longestPalindrome(s));
            System.out.println();
        }
    }
    public static String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        char[] t = new char[2 * s.length() + 3];

        t[0] = '^';

        int index = 1;

        for (char c : s.toCharArray()) {
            t[index++] = '#';
            t[index++] = c;
        }

        t[index++] = '#';
        t[index] = '$';

        int[] p = new int[t.length];

        int center = 0;
        int right = 0;

        for (int i = 1; i < t.length - 1; i++) {

            // Mirror of i around center
            int mirror = 2 * center - i;

            // Use previously computed values if possible
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand palindrome
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Find longest palindrome
        int maxLength = 0;
        int centerIndex = 0;

        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > maxLength) {
                maxLength = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLength) / 2;

        return s.substring(start, start + maxLength);
    }
}
