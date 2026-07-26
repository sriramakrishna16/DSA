//problem , given 2D array containing nums, where we have to find the target found in 2d array or 
// - not found using O(log n) time

// we must use binary search to find element in O(log n) time.
// solution is to manipulate the positions using mid value in 2D array matrix where mid is calculated
// - by using the total matrix capacity (if matrix is 4 * 5, then mid will be based on len 20)
// but mid 10 , 20 not found in matrix so we convert the mid into exact row and col position.

public class Search2DMatrix{
    public static void main(String args[]){
        int [][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 23;
        boolean ans = findTarget(nums, target);
        System.out.println(ans);
    }
    public static boolean findTarget(int [][] nums , int target){
        int left = 0;
        int right = nums.length * nums[0].length - 1;
        int rowLen = nums.length;
        int colLen = nums[0].length;
        while(left <= right){
            int mid = left + (right - left)/2;
            int row = mid / colLen;
            int col = mid % colLen;
            if(nums[row][col] == target){
                return true;
            }else if(nums[row][col] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}