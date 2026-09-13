package Z_LeetCode_Contest.Week519;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MinimumOperationsToMakeEveryElementPalindrome {
    public static void main(String [] args){
        int [] nums = {10,12,14,16};
        long ops = minOperations(nums);
        System.out.println(ops);
    }

    static List<Long>[] P = new ArrayList[2];
    static {
        P[0] = new ArrayList<>();
        P[1] = new ArrayList<>();
        long M = 1_000_000_000L;
        for(int v = 1; v < 100000; v++){
            String s = String.valueOf(v);
            String r = new StringBuilder(s).reverse().toString();
            long a1 = Long.parseLong(s.substring(0,s.length()-1)+r);
            long a2 = Long.parseLong(s+r);
            if(a1 < M) P[(int) (a1 & 1)].add(a1);
            if(a2< M) P[(int)(a2 & 1)].add(a2);
            Collections.sort(P[0]);
            Collections.sort(P[1]);
        }
    }

    public static long minOperations(int [] nums){
        long totalOperations = 0;
        for(int x : nums){
            List<Long> p = P[x & 1];
            int i = Collections.binarySearch(p, (long)x);
            if(i < 0) i = -(i+1);
            if(i >= p.size()){
                i = p.size()-1;
            }
            long fw = Math.abs(x - p.get(i));
            long bw = i > 0 ? Math.abs(x - p.get(i-1)) : fw;

            totalOperations += Math.min(fw, bw) / 2;
        }
        return totalOperations;
    }
    
}
