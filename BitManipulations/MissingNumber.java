package BitManipulations;

public class MissingNumber {
    public static void main(String args[]){
        int nums [] = {0,1,2,4};
        int ans = findMissingNumber(nums);
        System.out.println(ans);
    }
    // public static int findMissingNumber(int[] nums){
    //     int n = nums.length;
    //     int expectedSum =  n * (n + 1) / 2;
    //     int actualSum = 0;
    //     for(int i : nums){
    //         actualSum += i;
    //     }
    //     return expectedSum - actualSum;
    // }

    public static int findMissingNumber(int[] nums){
        int n = nums.length;
        int xor = n;
        for(int i = 0 ; i < n ; i++){
            xor ^= i;
            xor ^= nums[i];
        }
        return xor;
    }
}
