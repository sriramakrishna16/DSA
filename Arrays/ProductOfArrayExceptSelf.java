package Arrays;
import java.util.Arrays;

class ProductOfArrayExceptSelf {

    public static void main(String [] args){
        int nums[] = {1,2,3,4};
        int result[] = findProducts(nums);
        System.out.println(Arrays.toString(result));
    }


//brute force


//     public static int[] findProducts(int[] nums){
//         int n = nums.length;
//         int [] result = new int [n];
//         for(int i=0;i<nums.length;i++){
//             int product = 1;
//             for(int j=0;j<nums.length;j++){
//                 if(i!=j){
//                     product *= nums[j];
//                 }
//             }
//             result[i] = product;
//         }

//         return result;
//     }

//optimal version

    public static int[] findProducts(int[] nums){
        int n = nums.length;
        int [] left = new int[n];
        int [] right = new int[n];
        int [] result = new int[n];

        left[0] = 1;
        for(int i=1;i<n;i++){
            left[i] = left[i-1] * nums[i-1]; //1,2,3,4  1,1,2,6
        }

        right[n-1] = 1;
        for(int i = n-2;i>=0;i--){
            right[i] = right[i+1] * nums[i+1]; //1,2,3,4 ->      24,12,4,1 
        }

        for(int i=0;i<n;i++){
            result[i] = left[i] * right[i];
        }

        return result;
    }


}
