package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main (String [] args){
        String str = "()";
        boolean ans = isValid(str);
        System.out.println(ans);
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[') ){
                     return false;
                }
            }  
        }
    return stack.isEmpty(); 
    }
}

