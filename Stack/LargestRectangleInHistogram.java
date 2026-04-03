package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public static void main(String args[]){
        int heights[] = {2,1,5,6,7};
        int largestArea = findMaxArea(heights);
        System.out.println(largestArea);
    }
    private static int findMaxArea(int [] heights){
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int n = heights.length;
        for(int i = 0; i<=n;i++){  // 2 , 1, 5 , 6, 2, 3
            //if the last element is also biggest , we need one smaller element to 
            // process the rest of heights in stack , so we use one extra loop <=n 
            // and value 0 if i == n 
            int curr = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && curr < heights[stack.peek()] ){
                int h = heights[stack.pop()];
                int leftSmaller = stack.isEmpty() ? -1 : heights[stack.peek()];
                int width =  i - leftSmaller - 1; //
                max = Math.max(max , h * width );  
            }

            stack.push(i);
        }
        return max;
    }



     // brute force approach
    // private static int findMaxArea(int [] heights){
    //     int max = 0;
    //     for(int i = 0; i<heights.length;i++){  //2, 1, 5, 6, 3
    //         int left = i;
    //         int right = i;
    //         int height = heights[i];
    //         while(left > 0 && heights[left - 1] >= heights[i]){
    //             left--;
    //         }
    //         while(right < heights.length - 1 && heights[right + 1] >= heights[i]){
    //             right++;
    //         }
    //         int width = right - left + 1;
    //         int area = height * width;
    //         max = Math.max(max, area);
    //     }
        
    //     return max;
    // }
}
