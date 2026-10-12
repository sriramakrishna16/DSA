package Z_LeetCode_Contest.Week523;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSubsetSelection1 {
    public static void main(String [] args){
        int n = 15;
        int s = 15;
        List<Integer> ans = maxPrimes(n, s);
        System.out.println(ans);
    }
    public static List<Integer> maxPrimes(int n , int s){

        // seive of Eratosthenes for primes O(n log log n)
        
        /* boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        if (n >= 1) {
            isPrime[1] = false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int sum = 0;

        for (int i = 2; i <= n; i++) {

            if (isPrime[i]) {

                if (sum + i <= s) {
                    ans.add(i);
                    sum += i;
                } else {
                    break;
                }
            }
        }

        return ans; */


        // normal solution for finding primes O(n root n)
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 2; i <= n ; i++){
            if(isPrime(i)){
                if(sum + i <= s){
                    ans.add(i);
                    sum += i;
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    public static boolean isPrime(int num){
        if (num < 2){
            return false;
        }

        for(int i = 2 ; i <= Math.sqrt(num) ; i ++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

}
