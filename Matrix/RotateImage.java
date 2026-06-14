import java.util.Arrays;
import java.util.*;

//problem , given a n * n matrix , and rotate the matrix by 90 degree , with in-place.

//solution is to first transpose the matrix and swap rows.

public class RotateImage{
    public static void main(String args[]){
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateMatrix(matrix);
        for(int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
    public static void rotateMatrix(int [][] matrix){
        int n = matrix.length;

        //Transposing the matrix
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        //swapping column wise each row and increment column
        int left = 0;
        int right = n - 1;

        while(left < right){
            for(int i = 0 ; i < n ; i++){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
    }
}