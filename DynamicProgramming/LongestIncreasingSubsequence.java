package DynamicProgramming;


//Dynamic programming is not a best approach . It takes n * n times beacuse
// it have to check all previous elements(j) for every elemnt (i)


//Dynamic Approach

public class LongestIncreasingSubsequence {
    public static void main(String [] args){
        int nums [] = {10,9,2,5,3,7,101,18,110};
        int longestSeq = findSequence(nums);
        System.out.println(longestSeq);
    }

    // public static int findSequence(int nums[]){
        
    //     int n = nums.length;

    //     int dp [] = new int [n];

    //     for (int i = 0 ; i<n ; i++){
    //         dp[i] = 1;
    //     }

    //     for(int i = 0 ; i<n ; i++){
    //         for(int j = 0 ; j < i ; j++){
    //             if(nums[j] < nums[i]){
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //     }

    //     int max = 1;

    //     for(int x : dp){
    //         max = Math.max(max, x);
    //     }
    //     return max;
    // }


    //using binary approach for optimization

     public static int findSequence(int nums[]){
        int n = nums.length;
        int[] lis = new int [n];
        int size = 0;

        for(int num : nums){
            int left = 0;
            int right = size;

            while(left < right){
                int mid = left + (right - left) / 2; // 2,3,5
                if(lis[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            lis[left] = num;
            if(left == size){
                size++;
            }
        }
        return size;
     }
}
