//problem given a string , we have to find no of substrings that are palindromic

//ex : aba -> a , b , a, aba -> total 4 palindrome substrings

//i have used center approach , like every palindrome has a center value

//in aba , b is center and if we move positions , and if left == right(a == a) then aba is palindrome

//for palindrome with even center like abba -> there is no center value 
//so for even we have to take i, i+1 that checks b and b equals at i = 1, then move left--
//and right++ , a == a again palindrome

public class PalindromicSubstrings {
     public static void main(String[] args) {
        String s = "abba";
        int count = findPalindromes(s);
        System.out.println(count);
     }
     public static int findPalindromes(String s){
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int count = 0;
        for(int i = 0 ; i < s.length(); i++){
            // for odd palindromes with center
            count += expand(s, i, i);
            
            //for even palindromes
            count += expand(s, i, i+1);
        }

        return count;
     }
     public static int expand(String s, int left , int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left)== s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
     }

   
}

