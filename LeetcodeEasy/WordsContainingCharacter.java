package LeetcodeEasy;
import java.util.ArrayList;
import java.util.List;

public class WordsContainingCharacter {
    public static void main(String args[]){
        String [] words = {"rama","krishna"};
        char ch = 'm';
        List<Integer> ans = findWords(words,ch);
        System.out.println(ans);
    }
    public static List<Integer> findWords(String[] words, char ch){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            if(words[i].indexOf(ch) != -1){
                list.add(i);
            }
        }
        return list;
    }
}
