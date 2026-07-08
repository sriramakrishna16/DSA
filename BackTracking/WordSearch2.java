package BackTracking;

import java.util.ArrayList;
import java.util.List;

//problem , given 2d array of char and words
// we have find words using 2d array by traversing

//solution used trie, backtracking and pruning to optimise

public class WordSearch2 {
    
    public class TrieNode{
        TrieNode[] child = new TrieNode[26];
        String word;
        TrieNode(){
            child = new TrieNode[26];
            word = null;
        }
    }

    TrieNode root;
    WordSearch2() {root = new TrieNode();}

    public void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(node.child[i] == null){
                node.child[i] = new TrieNode();
            }
            node = node.child[i];
        }
        node.word = word;
    }
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words){
        for(String word : words)
            insert(word);

        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i< r; i++){
            for(int j = 0; j< c; j++){
                dfs(board, i , j, root);
            }
        }
        return ans;
    }

    public void dfs(char board[][], int i, int j, TrieNode node){
        if(i < 0 || j <0 || i >= board.length || j >= board[0].length){
            return;
        }

        char ch = board[i][j];

        if(ch == '#'){
            return;
        }
        
        node = node.child[ch - 'a'];

        if(node == null){
            return;
        }

        if(node.word != null){
            ans.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board, i, j+1, node);
        dfs(board, i, j-1, node);
        dfs(board, i+1,j, node);
        dfs(board, i-1,j, node);

        board[i][j] = ch;
    }
    public static void main(String args[]){
        char [][] board = {{'o','a','a','n'},
                            {'e','t','a','e'},
                            {'i','h','k','r'},
                            {'i','f','l','v'}};
        String [] words = {"oath","pea","eat","rain"};
        WordSearch2 w = new WordSearch2();
        List<String> ans = w.findWords(board, words);
        System.out.println(ans);
    }
}
