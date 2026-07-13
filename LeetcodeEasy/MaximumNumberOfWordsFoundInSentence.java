package LeetcodeEasy;

public class MaximumNumberOfWordsFoundInSentence {
    public static void main(String args[]){
        String[] s = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        int ans = findMax(s);
        System.out.println(ans);
    }
    public static int findMax(String [] sen){
        int max = 0;
        for(String s : sen){
            String[] n = s.split(" ");
            max = Math.max(max, n.length);
        }
        return max;
    }
}
