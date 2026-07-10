package Arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String args[]){
        int [] nums = {1};
        int k = 2;
        rotateArray(nums,k);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotateArray(int [] nums, int k){
        // int ans [] = new int [nums.length];
        // int n = nums.length;
        // for(int i = 0; i < n ; i++){
        //     ans[(i+k)%n] = nums[i];
        // }
        // for(int i = 0; i < n-1; i++){
        //     nums[i] = ans[i];
        // }

        //optimised approach O(1)

        // int n = nums.length;
        // k %= n;
        // for(int i = 0; i < n/2; i++){
        //     int temp = nums[i];
        //     nums[i] = nums[n - i -1];
        //     nums[n - i -1] = temp;
        // } //7,6,5,4,3,2,1
        // for(int i = 0 ; i < k/2 ; i++){
        //     int temp = nums[i];
        //     nums[i] = nums[k-i-1];
        //     nums[k-i-1] = temp;
        // }
        // int j = n - 1;
        // for(int i = k ; i < (k + n)/2 ; i++){
        //     int temp = nums[i];
        //     nums[i] = nums[j];
        //     nums[j] = temp;
        //     j--;
        // }

        //using function
        int n = nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,k,n-1);
        reverse(nums,0, k-1);
    }

    private static void reverse(int[] nums,int left,int right){
        while(left<=right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
