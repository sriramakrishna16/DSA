package Stack;
import java.util.Stack;

//problem , given a string which is in encoded format and we have to decode and return it back.

public class DecodeString {
    public static void main(String[] args){
        String s = "3[a2[c]]";
        String ans = decodeString(s);
        System.out.println(ans);
    }

    public static String decodeString(String s){
        Stack<String> strings = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else if(c == '['){
                counts.push(num);
                strings.push(curr.toString());
                num = 0;
                curr.setLength(0);
            }else if(c == ']'){
                int count = counts.pop();
                String previous = strings.pop();
                StringBuilder sb = new StringBuilder(previous);
                for(int i = 0 ; i < count ; i++){
                    sb.append(curr);
                }
                curr = sb;
            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
