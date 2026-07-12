package Arrays;

public class LongestCommonPrefix {
    public static void main(String args[]){
        String words[] = {"flower","flow","flight"};
        String ans = commonPrefix(words);
        System.out.println(ans);
    }
    public static String commonPrefix(String [] words){
        // StringBuilder sb = new StringBuilder(words[0]);
        // for(int i = 1; i < words.length; i++){
        //     int len = Math.min(words[i].length(),sb.length());
        //     StringBuilder temp = new StringBuilder();
        //     for(int j = 0; j<len ; j++){
        //         if(words[i].charAt(j) != sb.charAt(j))
        //             break;
        //         temp.append(words[i].charAt(j));
        //     }
        //     sb = temp;
        // }

        //O(1) space solution

        for(int i = 0; i< words[0].length(); i++){
            char ch = words[0].charAt(i);
            for(int j = 1; j<words.length; j++){
                if(i == words[j].length() ||words[j].charAt(i) != ch){
                    return words[0].substring(0,i);
                }
            }
        }
        return words[0];

    }
}
