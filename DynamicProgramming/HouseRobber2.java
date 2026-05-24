public class HouseRobber2{

    //problem same as house robber 1 but onlyy differnce is houses are connected in circle,
    //so taking robbing 1st house and last house can be a mistake here 
    //by dividing it into two cases
    //case1: leaving 1st house and rob until end
    //case2 : rob 1st house and continue then leave last house.
    public static void main(String args[]){
        int nums[] = {1};
        int ans = rob(nums);
        System.out.println(ans);
    }
    public static int rob(int [] nums){
        int len = nums.length;

        if(len == 0) return len;
        if(len == 1) return nums[0];

        int case1 = startRobbing(nums, 0, len-2);
        int case2 = startRobbing(nums, 1, len-1);

        int ans = Math.max(case1,case2);

        return ans;
    }
    public static int startRobbing(int [] nums , int start, int end){ //0, 2
        int len = end-start + 1;
        int [] dp = new int [len]; //1,2,4 

        if(len == 1) return nums[start];

        dp[0] = nums[start];
        dp[1] = Math.max(dp[start], nums[start + 1]);

        for(int i = 2; i < len; i++){
            int originalIndex = start + i;
            dp[i] = Math.max(dp[i-1], (dp[i-2] + nums[originalIndex]));
        }
        return dp[len-1];
    }
}