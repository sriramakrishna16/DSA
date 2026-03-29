package TwoPointers;

class RemoveDupliactesFromSortedArray{
    public static void main(String args[]){
        int[] nums = {1,1,2,2,3,3,4};
        int ans = removeDuplicates(nums);
        System.out.println(ans);
    }
    public static int removeDuplicates(int[] nums){
        int slow = 0;
        for(int fast = 1; fast<nums.length; fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}