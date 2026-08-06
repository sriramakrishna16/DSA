package Arrays;

public class FindPivotIndex {
    public static void main(String[] args){
        int [] nums = {1,7,3,6,5,6};
        int index = pivotIndex(nums);
        System.out.println(index);
    }

    public static int pivotIndex(int [] nums){
        int [] prefix = new int[nums.length + 1];
        for(int i = 0 ; i < nums.length ; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        for(int i = 0 ; i < nums.length; i++){
            int left = prefix[i];
            int right = prefix[nums.length] - prefix[i+1];
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}
