package BitManipulations;
//find the single number among multiple twice number

//Must implement solution with a linear runtime complexity and use only constant extra space.

//we can simple use xor operation as duplicates got cancelled and remains single element.
public class SingleNumber {
    public static void main(String[] args){
        int nums [] = {4,1,2,1,2};
        int ans = singleNumber(nums);
        System.out.println(ans);
    }
    public static int singleNumber(int nums[]){
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
