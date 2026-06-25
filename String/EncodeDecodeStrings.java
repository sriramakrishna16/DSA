import java.util.ArrayList;
import java.util.List;

//problem , given a list of strngs , we have encode list of strings into single string and again decode 
// as it is.
//we use len and # character to identify the string while encoding  ex: 5#hello5#world
//and while decoding we use len to identify string len and # to identify where string starts
//simple length solution will because some strings may contain nums at start like 123hello, 16srk
//so we use # to identify where strings starts and then we jump to end of the length irresptive of what 
//string contains.

public class EncodeDecodeStrings {
    public static void main(String args[]){
        String[] s = {"hello","world","123testing"};
        String encodedString = encode(s);
        System.out.println(encodedString);

        List<String> decodedString = decode(encodedString);
        for(String st : decodedString){
            System.out.println(st);
        }
    }

    public static String encode(String[] strs){
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
            // sb.append(s.length()).append(s); //without using #, fails at strings like 16srk
        }
        return sb.toString();
    }
    public static List<String> decode(String s){
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < s.length()){

            int j = i;

            while(j < s.length() && s.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(s.substring(i,j));

            list.add(s.substring(j+1, j+1+len));

            i = j + len + 1;

            //logic without using # , but it fails when string starts int like 1abc

            // int len = 0;

            // while( j < s.length() && Character.isDigit(s.charAt(j))){
            //     len = len * 10 + (s.charAt(j) - '0');
            //     j++;
            // }
            // list.add(s.substring(j,j+len));

            // i = j + len ; 
        }
        return list;
    }
}
