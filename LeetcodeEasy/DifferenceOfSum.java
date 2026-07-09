package LeetcodeEasy;

public class DifferenceOfSum {
    public static void main(String args[]){
        int [] nums = {12345,1};
        int ans = findDiff(nums);
        System.out.println(ans);
    }
    public static int findDiff(int [] nums){
        int sum=0;
        int digitSum = 0;
        for(int num : nums){
            sum += num;
            while(num > 0){
                digitSum += num % 10;
                num /= 10;
            }
        }
        return sum - digitSum;
    }
}
