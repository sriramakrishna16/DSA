package Stack;

import java.util.Stack;

//problem , given a string which includes *
// we have return the string after processing it by removing left near character to the star.

public class RemovingStarsFromAString {
    public static void main(String[] args){
        String s = "leet**cod*e";
        String ans = removeStars(s);
        System.out.println(ans);
    }
    public static String removeStars(String s){
        // Stack<Character> stack = new Stack<>();
        // for(char ch : s.toCharArray()){
        //     stack.push(ch);
        // }
        // StringBuilder sb = new StringBuilder();
        // int count = 0; 
        // while(!stack.isEmpty()){
        //     char c = stack.pop(); 
        //     if(c != '*' && count == 0){
        //         sb.append(c); 
        //     }else if(c == '*'){
        //         count++;
        //     }else{
        //         count--;
        //     }
        // }
        // return sb.reverse().toString();

        //more optimised without stack
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                count++;
            } 
            else if (count > 0) {
                count--;
            } 
            else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
