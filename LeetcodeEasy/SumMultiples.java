package LeetcodeEasy;

public class SumMultiples {
    public static void main(String args[]){
        int n = 7;
        int ans = sumMultiples(n);
        System.out.println(ans);
    }
    public static int sumMultiples(int n){
        int sum=0;
        for(int i = 1 ; i<=n; i++){
            if(i % 3 == 0 || i%5==0 || i%7 == 0){
                sum += i;
            }
        }
        return sum;
    }
}
