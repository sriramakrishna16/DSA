public class ReverseVowelsInString {
    public static void main(String[] args){
        String s = "IceCreAm";
        String ans = reverse(s);
        System.out.println(ans);
    }
    public static String reverse(String s){
        int start = 0;
        int end = s.length()-1;
        char [] ch = s.toCharArray();
        while(start < end){
            while(start < end && !isVowel(ch[start])){
                start++;
            }
            while(start < end && !isVowel(ch[end])){
                end--;
            }
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }
    private static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
