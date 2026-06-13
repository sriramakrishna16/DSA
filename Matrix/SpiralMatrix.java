import java.util.*;

//problem , given 2D array matrix , so that we print values in spiral order
//logic is to print top , and then down and then left and then up
//after finishing each boundary top or down or left or right, increment the boundary.
//again it continous top,down,left and right.

public class SpiralMatrix {
    public static void main(String args[]){
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans = findSpiral(matrix);
        System.out.println(ans);
    }
    public static List<Integer> findSpiral(int[][] matrix){
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        //we must allow top while top and bottom on same line, but should not allow bottom execution
        while(top <= bottom && left <= right){

            //moving top
            for(int i = left; i <= right ; i++){
                result.add(matrix[top][i]);
            }
            top++;

            //moving down
            for(int i = top ; i <= bottom ; i++){
                result.add(matrix[i][right]);
            }
            right--;

            //moving left
            //avoiding bottom execution if the boundaries are same, if allowed , will print duplicates
            if(top <= bottom){
                for(int i = right ; i >= left ; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //moving up
            if(left <= right){
                for(int i = bottom ; i >= top ; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
