package LeetcodeEasy;

public class XOROperation {
    public static void main(String args[]){
        int n = 5;
        int start = 0;
        int ans = xorOp(n,start);
        System.out.println(ans);
    }
    public static int xorOp(int n, int start){
        int ans=0;
        for(int i = 0; i<n ; i++){
            ans ^= start + 2 * i;
        }
        return ans;
    }
}
