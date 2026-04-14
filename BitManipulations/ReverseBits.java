package BitManipulations;

//problem reversing an integer (32 bit)
public class ReverseBits {
    public static void main(String args[]){
        int num = -1073741824;
        int ans = reverse(num);
        System.out.println(ans);
    }
    public static int reverse(int num){
        int ans = 0;
        for(int i = 0 ; i< 32; i++){
            int bit = num & 1;
            ans = (ans << 1) | bit;
            num = num >>> 1;
        }
        return ans;
    }
    
}
