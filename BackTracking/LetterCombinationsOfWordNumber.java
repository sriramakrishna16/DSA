package BackTracking;
import java.util.*;

//problem , given some digits as string where each digit ranges from 2-9 and 
// each digit indicates letters like old keypad mobile 
// we have to map the letters using digits example 23 - > 2(abc) and 3(def) 
// map should be like ad ae af bd be bf cd ce cf in any order. 

public class LetterCombinationsOfWordNumber {
    public static void main(String args[]){
        String digits = "23";
        List<String> ans = combinations(digits);
        System.out.println(ans);
    }
    static String [] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> ans = new ArrayList<>();
    public static List<String> combinations(String digits){
        if(digits.length() == 0 || digits == null) return ans;
        backtrack(digits, 0, new StringBuilder());
        return ans;
    }
    private static void backtrack(String digits, int index , StringBuilder curr){
        if(index == digits.length()){
            ans.add(curr.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        
        for(char ch : letters.toCharArray()){
            curr.append(ch);
            backtrack(digits,index + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
