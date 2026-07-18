package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String args[]){
        String tokens[] = {"2","1","+","3","*"};
        int ans = evalRPN(tokens);
        System.out.println(ans);
    }
    public static int evalRPN(String [] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                if(token.equals("+")) stack.push(a + b);
                if(token.equals("-")) stack.push(a - b);
                if(token.equals("*")) stack.push(a * b);
                if(token.equals("/")) stack.push(a / b);
            }else
                stack.push(Integer.parseInt(token));
        }
        return stack.peek();
    }
}
