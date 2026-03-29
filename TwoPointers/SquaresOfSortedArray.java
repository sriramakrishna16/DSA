package TwoPointers;

public class SquaresOfSortedArray {
    public static void main(String args[]){
        int[] nums = {-4,-1,0,3,10};
        int[] ans = squares(nums);
        for(int num: ans){
            System.out.print(num + " ");
        }
    }
    public static int[] squares(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int[] sorted = new int[nums.length];
        int pos = nums.length - 1;
        while(left <= right){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if(leftSquare < rightSquare){
                sorted[pos] = rightSquare;
                right--;
            }else{
                sorted[pos] = leftSquare;
                left++;
            }
            pos--;
        }
        return sorted;
    }
}


//TimeComplexity : O(n)
//SpaceComplexity : O(n)