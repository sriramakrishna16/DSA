import java.util.*;

//problem , given that 2d array or matrix with 1s and 0s
//if we found any 0 in matrix , then we have to make that entire row and column zero

//by looping , if we get 0, then making the entire row and column 0 looks works but it 
//wrong approch. Becz after looping to next element , our own 0 will again makes entire 
//row and column zero

//so we have to mark first , which row and col has zero usually by using first row and col
//then at last by using first row and col , make the desired row and columns zeroes

public class SetMatrixZeroes {
    public static void main(String args[]){
        int [][] matrix = {{1,1,0},{1,1,1},{1,1,1}};
        setZeroes(matrix);
        for(int[] list : matrix){
            System.out.println(Arrays.toString(list));
        }
    }

    public static void setZeroes(int [][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;

        boolean firstRow = false;
        boolean firstCol = false;

        //checking first col if any zero contains
        for(int i = 0 ; i < c ; i++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        //checking first row if any zeroes contain
        for(int j = 0 ; j < c ; j++){
            if(matrix[j][0] == 0){
                firstCol = true;
                break;
            }
        }

        //marking first row and col if zero found
        for(int i = 1; i < r ; i++){
            for(int j = 1; j < c ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //setting zeroes based on markers
        for(int i = 1 ; i < r ; i++){
            for(int j = 1 ; j < c ; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //at last firstrow and first columns has zeroes , then make then zeroes
        
        if(firstRow){
            for(int i = 0 ; i < c ; i++){
                matrix[0][i] = 0;
            }
        }

        if(firstCol){
            for(int i = 0 ; i < r ; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
