package Trie;

import Trie.Trie.TrieNode;

public class Trie {
    public class TrieNode{
        TrieNode [] child = new TrieNode[26];
        boolean isWord;
        TrieNode(){
            child = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(node.child[index] == null){
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.isWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(node.child[index] == null){
                return false;
            }
            node = node.child[index];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            int index = ch - 'a';
            if(node.child[index] == null){
                return false;
            }
            node = node.child[index];
        }
        return true;
    }

    public static void main(String args[]){
        String a = "cat";
        String b = "car";
        String c = "care";

        Trie t = new Trie();

        t.insert(a);
        t.insert(b);
        t.insert(c);

        System.out.println(t.search(a));
        System.out.println(t.search(b));
        System.out.println(t.search(c));

        System.out.println(t.startsWith("ca"));
        System.out.println(t.startsWith("car"));
        System.out.println(t.startsWith("co"));
    }
}
