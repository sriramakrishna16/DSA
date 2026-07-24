import java.util.Arrays;
import java.util.*;

public class WordLadder {
    public static void main(String args[]){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
    public static int ladderLength(String beginWord , String endWord, List<String> words){
        HashSet<String> set = new HashSet<>(words);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                if(curr.equals(endWord)) return level;
                char [] arr = curr.toCharArray();
                for(int i = 0 ; i < arr.length ; i++){
                    char original = arr[i];
                    for(char c = 'a' ; c <= 'z' ; c++){
                        arr[i] = c;
                        String s = new String(arr);
                        if(set.contains(s)){
                            q.offer(s);
                            set.remove(s);
                        }
                    }
                    arr[i] = original;
                }
            }
            level++;
        }
        return -1;
    }
}
