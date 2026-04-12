package BitManipulations;

public class NoOfOneBits {
    public static void main(String [] args){
        int a = 2147483645;

        int ans = findOnes(a);
        System.out.println(ans);

    }
    // public static int findOnes(int a){
    //     int count = 0;
    //     while(a != 0){
    //         int n = (a & 1);
    //         if(n == 1) count++;
    //         a = a >> 1;
    //     }
    //     return count;
    // }

    //more optimised solution
    public static int findOnes(int a){
        int count = 0;
        while(a != 0){
            a = a & (a - 1);
            count++;
        }
        return count;
    }
}
