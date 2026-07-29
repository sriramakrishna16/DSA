//problem, given a number , we have to find the end zeroes

// formula n/5,n,25,n,125... until denominator < n.
// in code we simply do -> n = n/5 until n > 0. same as formulae.

public class FactorialTrailingZeroes{
    public static void main(String args[]){
        int n = 100;
        int ans = trailingZeroes(n);
        System.out.println(ans);
    }
    public static int trailingZeroes(int n){
        int count = 0;
        while(n > 0){
            n = n / 5;
            count += n;
        }
        return count;
    }
}