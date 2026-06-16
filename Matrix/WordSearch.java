public class WordSearch {
    public static void main(String args[]){
        char [][] words = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        boolean ans = findWord(words, word);
        System.out.println(ans);
    }
    public static boolean findWord(char [][] words , String target){
        int r = words.length;
        int c = words[0].length;
        int index = 0;

        for(int i = 0 ; i < r ; i++){
            for(int j = 0; j < c ; j++){
                if(dfs(words, target, i , j , index)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char [][] words , String target , int i , int j , int idx){
        if(target.length() == idx){
            return true;
        }

        if(i < 0 || j < 0 || i >= words.length || j >= words[0].length || words[i][j] != target.charAt(idx)){
            return false;
        }

        char temp = words[i][j];

        words[i][j] = '#';

        boolean found =
            dfs(words, target , i + 1, j , idx + 1) ||
            dfs(words, target , i - 1, j , idx + 1) ||
            dfs(words, target , i , j + 1, idx + 1) ||
            dfs(words, target , i , j - 1, idx + 1);

        words[i][j] = temp;

        return found;
    }
    
}
