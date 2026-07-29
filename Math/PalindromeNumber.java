public class PalindromeNumber{
    public static void main(String [] args){
        int num = 1229;
        boolean ans = isPalindrome(num);
        System.out.println(ans);
    }
    public static boolean isPalindrome(int num){
        if(num < 0) return false;
        int rev = 0;
        int x = num;
        while(x != 0){
            int lastDigit = x % 10;
            x /= 10;
            rev = lastDigit + rev * 10;
        }
        return rev == num;
    }
}