package Stack;
import java.util.Stack;

public class BasicCalculator {
    public static void main(String args[]){
        String s = "(1+(4+5+2)-3)+(6+8)";
        int ans = calculate(s);
        System.out.println(ans);
    }
    public static int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += num * sign;
                i--;
            }else if(ch == '+'){
                sign = 1;
            }else if(ch == '-'){
                sign = -1;
            }else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(ch == ')'){
                int prevSign = stack.pop();
                int prevRes = stack.pop();

                result = prevRes + prevSign * result;
            }
        }
        return result;
    }
}
