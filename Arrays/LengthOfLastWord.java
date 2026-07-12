package Arrays;

public class LengthOfLastWord {
    public static void main(String args[]){
        String s = "   fly me   to   the moon  ";
        int ans = findLen(s);
        System.out.println(ans);
    }
    public static int findLen(String s){
        // s = s.trim();
        // while(s.contains("  ")){
        //     s = s.replace("  "," ");
        // }

        // StringBuilder sb = new StringBuilder();
        // boolean prevSpace = false;
        // for(char c : s.toCharArray()){
        //     if(c == ' '){
        //         if(!prevSpace){
        //             sb.append(c);
        //             prevSpace = true;
        //         }
        //     }else{
        //         sb.append(c);
        //         prevSpace = false;
        //     }
        // }
        // System.out.println(sb.toString());

        //O(n) and o(n) sollution
        // int len = 0;
        // String words[] = s.trim().split("\\s+");
        // return words[words.length -1].length();

        //O(n) and O(1) solution
        int i = s.length()-1;
        while(i >= 0 && s.charAt(i) == ' ') i--;
        int len = 0;
        while(i>=0 && s.charAt(i) != ' '){
            len++;
            i--;
        }
        return len;
    }
}
