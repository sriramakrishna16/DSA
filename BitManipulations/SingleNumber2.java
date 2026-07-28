package BitManipulations;

//problem, give nums where every element appears thrice except one element 
// we have to find that single element

//solution idea , create a mask and do left shift operation while doing
// check every bit in all nums , if 1 found make count increase ... 
// after that remove common by % 3(becz thrice) and we get the bit for unique
// do or | operation with result to place the unique bit

public class SingleNumber2 {
    public static void main(String[] args){
        int[] nums = {0,1,0,1,0,1,99};
        int ans = singleNumber(nums);
        System.out.println(ans);
    }

    public static int singleNumber(int [] nums){
        int result = 0;
        for(int i = 0 ; i < 32 ; i++){
            int count = 0;
            for(int num : nums){
                if((num & (1 << i)) != 0){
                    count++;
                }
            }
            if(count % 3 != 0){
                result |= (1 << i);
            }
        }
        return result;
    }
}
