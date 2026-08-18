import java.util.*;

public class SearchSuggestionSystem {
    public static void main(String [] args){
        String [] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        SearchSuggestionSystem s = new SearchSuggestionSystem();
        List<List<String>> ans = s.suggestedProducts(products, searchWord);
        System.out.println(ans);
    }
    public class TrieNode{
        TrieNode [] child = new TrieNode[26];
        List<String> products = new ArrayList<>();
    }
    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord){
        Arrays.sort(products);
        for(String product : products){
            insert(product);
        }
        List<List<String>> ans = new ArrayList<>();
        TrieNode node = root;
        for(char ch : searchWord.toCharArray()){
            int index = ch - 'a';
            if(node != null && node.child[index] != null){
                node = node.child[index];
                ans.add(node.products);
            }else{
                node = null;
                ans.add(new ArrayList<>());
            }
        }
        return ans;
    }
    public void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.child[index] == null){
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
            if(node.products.size() < 3){
                node.products.add(word);
            }
        }
    }
}
