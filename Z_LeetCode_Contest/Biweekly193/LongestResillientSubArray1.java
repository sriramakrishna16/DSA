package Z_LeetCode_Contest.Biweekly193;

public class LongestResillientSubArray1 {
    void main(){
        int [] nums = {2,4,6,3};
        int k = 2;
        int ans = resillientSubArray(nums, k);
        IO.println(ans);
    }
    int resillientSubArray(int [] nums , int k){
        // int n = nums.length;
        // int maxLength = 1;

        // for(int i = 0; i < n; i++){
        //     int sum = 0;

        //     for(int j = i ; j < n ; j++){
        //         sum += nums[j];

        //         boolean valid = true;

        //         for(int x = i; x <= j ; x++){
        //             int remainingSum = sum - nums[x];

        //             if(remainingSum % k != 0){
        //                 valid = false;
        //                 break;
        //             }
        //         }
        //         if(valid){
        //             int length = j - i + 1;
        //             maxLength = Math.max(maxLength, length);
        //         }
        //     }
        // }
        // return maxLength;

        // optimised solution

        // formula , first we have to check all elements remainders are same
        // if same , we delete one element and check their product of remainders divides by k

        // that is (S- x) mod k = 0
        //  s mod k = x mod k mean sum modulous equal to the modulous of element we are deleting

        // therefore , length - 1 * remainder % k == 0 then it is resillient
        // for suppose if all elements remainders same , we can delete any element from it then
        //  length is length - 1 * remainder(all same) modulous of k == 0 then resillient

        int n = nums.length;
        int maxLength = 1;
        for(int i = 0 ; i < n ; i++){
            int remainder = Math.floorMod(nums[i], k);
            for(int j = i ; j < n ; j++){
                if(Math.floorMod(nums[j], k) != remainder){
                    break;
                }
                int length = j - i + 1;
                long value = (long) (length - 1) * remainder;

                if(value % k == 0){
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;

    }
}
