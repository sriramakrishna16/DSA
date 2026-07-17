package Stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String args[]){
        String path = "/.../a/../b/c/../d/./";
        String ans = simplifyPath(path);
        System.out.println(ans);
    }
    public static String simplifyPath(String path){
        String [] words = path.split("/");

        Stack<String> stack = new Stack<>();
        
        for(String word : words){
            if(word.equals("") || word.equals(".")){
                continue;
            }
            if(word.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(word);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(String s : stack){
            sb.append("/").append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
