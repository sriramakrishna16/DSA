package Arrays;

//problem -> given string that is "    the    sky is blue   "
// we have to return in reverse that is -> "blue is sky the" without extra spaces
public class ReverseWordsInString {
    public static void main(String args[]){
        String words = "  hello world  ";
        String ans = reverse(words);
        System.out.println(ans);
    }
    public static String reverse(String s){
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            if(i < 0){
                break;
            }
            int j = i;
            while(j >= 0 && s.charAt(j) != ' '){
                j--;
            }
            if(sb.length()>0) sb.append(" ");
            sb.append(s.substring(j+1,i+1));
            i = j;
        }
        return sb.toString();
    }
}
