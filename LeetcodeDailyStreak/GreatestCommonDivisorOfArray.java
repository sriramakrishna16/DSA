package LeetcodeDailyStreak;

public class GreatestCommonDivisorOfArray {
    public static void main(String args[]){
        int nums [] = {2,5,6,9,10};
        int ans = findGCD(nums);
        System.out.println(ans);
    }
    public static int findGCD(int [] nums){
        int big = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for(int num : nums){
            big = Math.max(num,big);
            small = Math.min(num,small);
        }
        while(small != 0){
            int temp = small;
            small = big % small;
            big = temp;
        }
        return big;
    }
}
