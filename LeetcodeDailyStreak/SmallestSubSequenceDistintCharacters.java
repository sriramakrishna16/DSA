package LeetcodeDailyStreak;

public class SmallestSubSequenceDistintCharacters {
    public static void main(String args[]){
        String s = "cbacdcbc";
        String ans = smallestSubsequence(s);
        System.out.println(ans);
    }
    public static String smallestSubsequence(String s){
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']--;

            if (visited[ch - 'a']) {
                continue;
            }

            while (stack.length() > 0 &&
                   ch < stack.charAt(stack.length() - 1) &&
                   freq[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                visited[removed - 'a'] = false;
            }

            stack.append(ch);
            visited[ch - 'a'] = true;
        }

        return stack.toString();
    }
}
