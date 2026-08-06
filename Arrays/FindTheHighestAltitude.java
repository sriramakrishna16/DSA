package Arrays;

public class FindTheHighestAltitude {
    public static void main(String [] args){
        int [] nums = {-4,-3,-2,-1,4,3,2};
        int ans = largestAltitude(nums);
        System.out.println(ans);
    }

    public static int largestAltitude(int [] nums){
        // int [] prefix = new int[nums.length + 1];
        // int max = Integer.MIN_VALUE;
        // for(int i = 0 ; i < nums.length ; i++){
        //     prefix[i+1] = prefix[i] + nums[i];
        //     max = Math.max(Math.max(prefix[i+1],prefix[i]), max);
        // }
        // return max;

        //optimal
        int altitude = 0;
        int max = 0;
        for (int gain : nums) {
            altitude += gain;
            max = Math.max(max, altitude);
        }
        return max;
    }
}
