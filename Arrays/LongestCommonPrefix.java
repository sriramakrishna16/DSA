package Arrays;

public class LongestCommonPrefix {
    public static void main(String args[]){
        String words[] = {"flower","flow","flight"};
        String ans = commonPrefix(words);
        System.out.println(ans);
    }
    public static String commonPrefix(String [] words){
        StringBuilder sb = new StringBuilder(words[0]);
        for(int i = 1; i < words.length; i++){
            int len = Math.min(words[i].length(),sb.length());
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j<len ; j++){
                if(words[i].charAt(j) != sb.charAt(j))
                    break;
                temp.append(words[i].charAt(j));
            }
            sb = temp;
        }
        return sb.toString();
    }
}
