package Trie;
import java.util.*;

//problem , given a list of dictionary words and sentenece 
// we have to find root words of sentenece and dictionary and then return the sentence with replacing by root words.

//solution invovles implementation of Trie with insearch and required search functionality

public class ReplaceWords {
    public class TrieNode{
        TrieNode [] child = new TrieNode[26];
        boolean isWord;
        TrieNode(){
            child = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;
    ReplaceWords(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(node.child[i] == null){
                node.child[i] = new TrieNode();
            }
            node = node.child[i];
        }
        node.isWord = true;
    }

    public String replace(List<String> dict , String sentence){
        for(String root : dict){
            insert(root);
        }
        StringBuilder sb = new StringBuilder();
        String[] s = sentence.split(" ");
        for(String word : s){
            sb.append(search(word));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String search(String word){
        TrieNode node = root;

        StringBuilder prefix = new StringBuilder();

        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(node.child[i] == null){
                return word;
            }
            node = node.child[i];
            prefix.append(ch);

            if(node.isWord){
                return prefix.toString();
            }
        } 
        return word;
    }

    public static void main(String args[]){
        List<String> dic = new ArrayList<>(List.of("cat", "bat", "rat"));
        String sen = "the cattle was rattled by the battery";
        ReplaceWords r = new ReplaceWords();
        String ans = r.replace(dic, sen);
        System.out.println(ans);
    }
}
