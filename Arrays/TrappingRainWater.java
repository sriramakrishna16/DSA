package Arrays;

public class TrappingRainWater {
    public static void main(String args[]){
        int [] water = {4,2,0,3,2,5};
        int ans = trappedWater(water);
        System.out.println(ans);
    }
    public static int trappedWater(int [] heights){
        // Two pointers , o(n) and o(1) solution

        // int leftMax = 0, rightMax = 0, water = 0;
        // int left = 0;
        // int right = heights.length - 1;
        // while(left < right){
        //     if(heights[left] <= heights[right]){
        //         if(heights[left] > leftMax){
        //             leftMax = heights[left];
        //         }else{
        //             water += leftMax - heights[left];
        //         }
        //         left++;
        //     }else{
        //         if(heights[right] > rightMax){
        //             rightMax = heights[right];
        //         }else{
        //             water += rightMax - heights[right];
        //         }
        //         right--;
        //     }
        // }
        // return water;

        //prefix and suffix O(n) and O(n) solution
        int n = heights.length;

        int prefix [] = new int [n];
        int suffix [] = new int [n];

        prefix[0] = heights[0];
        for(int i = 1; i<n ; i++){
            if(heights[i] > prefix[i-1])
                prefix[i] = heights[i];
            else
                prefix[i] = prefix[i-1];
        }

        suffix[n-1] = heights[n-1];
        for(int i = n-2 ; i>=0 ; i--){
            if(heights[i] > suffix[i+1])
                suffix[i] = heights[i];
            else
                suffix[i] = suffix[i+1];
        }

        int water = 0;
        for(int i = 0; i < n ; i++){
            water += Math.min(suffix[i],prefix[i]) - heights[i];
        }
        return water;
    }
}
