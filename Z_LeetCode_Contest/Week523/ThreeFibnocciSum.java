public class ThreeFibnocciSum {
    public static void main(String [] args){
        int n = 16;
        boolean ans = threeFibSum(n);
        System.out.println(ans);
    }
    public static boolean threeFibSum(int n){
        int a = 0;
        int b = 1;
        int c = 1;

        while(a + b + c <= n){
            int ans = a + b + c;
            if (ans == n){
                return true;
            }
            int next = b + c;
            a = b;
            b = c;
            c = next;
        }
        return false;
    }
}
