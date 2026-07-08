package Trie;

public class WordDictionary {
    public class TrieNode{
        TrieNode [] child = new TrieNode[26];
        boolean isWord;
        TrieNode(){
            child = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;
    public WordDictionary(){
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

    public boolean search(String word){
        return dfs(word , 0, root);
    }

    public boolean dfs(String word, int index, TrieNode node){
        if(index == word.length()){
            return node.isWord;
        }
        char ch = word.charAt(index);
        if(word.charAt(index) != '.'){
            if(node.child[ch - 'a'] == null){
                return false;
            }
            return dfs(word, index+1, node.child[ch - 'a']);
        }

        for(int i = 0; i< 26; i++){
            if(node.child[i] != null){
                return dfs(word, index + 1, node.child[i]);
            }
        }
        return false;
    }

    public static void main(String args[]){
        String a = "cat";
        String b = "car";
        String c = "care";

        WordDictionary w = new WordDictionary();
        w.insert(a);
        w.insert(b);
        w.insert(c);

        System.out.println(w.search(a));
        System.out.println(w.search("c.t"));
        System.out.println(w.search("ca."));

    }
}
