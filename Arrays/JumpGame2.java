package Arrays;

public class JumpGame2 {
    public static void main(String args[]){
        int nums [] = {2,3,1,0,0,4};
        int ans = canJump(nums);
        System.out.println(ans);
    }
    public static int canJump(int [] nums){
        //JumpGame1

        // int maxJump = 0;
        // int len = nums.length;
        // for(int i = 0 ; i < len-1 ; i++){
        //     if(i > maxJump){
        //         return false;
        //     }
        //     maxJump = Math.max(i + nums[i],maxJump);
        //     if(maxJump >= len - 1){
        //         return true;
        //     }
        // }
        // return true;

        //jumpgame 2 : return minimum number of jumps to reach end
        //(2,3,1,0,0,4)
        int jumps = 0;
        int currentEnd = 0;
        int bestPlace = 0;
        int len = nums.length;
        for(int i = 0 ; i < len - 1; i++){
            bestPlace = Math.max(bestPlace,i + nums[i]);
            
            if (i == currentEnd) {
                if (currentEnd == bestPlace) {
                    return -1; 
                }
                jumps++;
                currentEnd = bestPlace;
            }
        }
        return jumps;
    }
}
