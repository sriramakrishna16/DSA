import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String args[]){
        int n = 3;
        List<String> ans = generate(n);
        System.out.println(ans);
    }
    static List<String> ans = new ArrayList<>();
    public static List<String> generate(int n){
        backtrack(n,0,0, new StringBuilder());
        return ans;
    }
    public static void backtrack(int n , int open , int close , StringBuilder sb){
        if(sb.length() == 2 * n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            backtrack(n, open + 1, close , sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open){
            sb.append(")");
            backtrack(n, open, close + 1 , sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
