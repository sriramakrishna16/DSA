package DynamicProgramming;

public class MaximumProductSubArray {
    public static void main(String args[]){
        int nums [] = {2,-3,-2,-4};
        int answer = findMax(nums);
        System.out.println(answer);
    }

    //kadane algorithm is not enough for this solution, becz minus values beacome bigger products
            //.......if another minus number arrives
            // so we cannot completely avoid minus values
            // so i am using dp by storing both min and max values, so min can also be turn into max value
    public static int findMax(int[] nums){
        int min = nums[0];
        int max = nums[0];
        int result = 0;

        for(int i = 1;i<nums.length; i++){
            int current = nums[i];

            int tempMax = Math.max(current, Math.max(current * max, current * min));

            int tempMin = Math.min(current , Math.min(current * max , current * min));

            max = tempMax;
            min = tempMin;

            result = Math.max(max, result);
        }

        return result;
    }
}
