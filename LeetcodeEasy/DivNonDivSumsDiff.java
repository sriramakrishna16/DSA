package LeetcodeEasy;

public class DivNonDivSumsDiff {
    public static void main(String args[]){
        int n = 10;
        int m = 3;
        int ans = findDiff(n,m);
        System.out.println(ans);
    }
    public static int findDiff(int n, int m){
        int divSum=0,nonDivSum=0;
        for(int i = 1 ; i<=n; i++){
            if(i % m == 0){
                divSum += i;
            }else{
                nonDivSum += i;
            }
        }
        return nonDivSum - divSum;
    } 
}
