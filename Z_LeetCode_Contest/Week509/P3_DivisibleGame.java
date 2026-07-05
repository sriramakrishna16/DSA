import java.util.HashMap;
import java.util.HashSet;

//problem , given array so that we have to find the factors that divide the num in nums 
// if it divides perfectly then it is +num , else -num
//so at last we have to return best sum among l and r(sub array) ,with least divisor k

//simply we use kadane algo , because kadane finds best maxSub (l and r) without mentioning l and r
//and we have return least div with maxSum and multiply both (div * maxSum)
// and return in reterms of modulo.

public class P3_DivisibleGame{
    public static void main(String args[]){
        int nums [] = {1,4,6,8};
        int ans = findMax(nums);
        System.out.println(ans);
    }
    public static int findMax(int [] nums){
        final int MOD = 1_000_000_007;

        int max = 0;
        for(int num : nums){
            max = Math.max(num, max);
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            for(int d = 2 ; d * d <= num ; d++){
                if(num % d == 0){
                    set.add(d);
                    set.add(num/d);
                }
            }
            if(num > 1){
                set.add(num);
            }
        }

        set.add(max + 1);

        long bestScore = Long.MIN_VALUE;
        int bestK = Integer.MAX_VALUE;

        for(int k : set){
            long currentSum = 0;
            long maxSubArray = Long.MIN_VALUE;
            for(int num : nums){
                long value;
                if(num % k == 0){
                    value = num;
                }else{
                    value = -num;
                }
                currentSum = Math.max(value , currentSum + value);
                maxSubArray = Math.max(maxSubArray , currentSum);
            }

            if(maxSubArray > bestScore){
                bestScore = maxSubArray;
                bestK = k;
            }else if(maxSubArray == bestScore && k < bestK){
                bestK = k;
            }
        }

        long ans = (bestScore * bestK) % MOD;
        if(ans < 0){
            ans += MOD;
        }

        return (int)ans;
    }
}