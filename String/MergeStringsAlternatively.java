public class MergeStringsAlternatively{
    public static void main(String args[]){
        String word1 = "abc";
        String word2 = "pqrstu";
        String ans = merge(word1,word2);
        System.out.println(ans);
    }

    public static String merge(String word1, String word2){
        int len = Math.max(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            if(i < word1.length())
                sb.append(word1.charAt(i));
            if(i < word2.length())
                sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}