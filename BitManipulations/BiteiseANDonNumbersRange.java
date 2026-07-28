package BitManipulations;
//problem , given an integer range left and right
// we have to return the bitwise and of all numbers in range

// doing uisng for loop takes a very large time as range can go upto 2^31
// so we use simple technique... And operation returns zero for every differnet bits
// so we can simple eleminate the all different bit, performing opertions on diff bits is unneccessary for Bitwise And

// so we right shit 1 until bit become equal so different bit gone and equal bit stays and make count for every shift
// now re construct the equal bits but using total shifts and left shift operation.

//example :
// 11101
// 11110
// 11111

//only first 10 are common , so right shift until equals , we get 111 and total shifts 2
// now left shift 111 -> 11100 , this is the final answer

public class BiteiseANDonNumbersRange {
    public static void main(String args[]){
        int left = 5;
        int right = 7;
        int ans = rangeBitwiseAnd(left, right);
        System.out.println(ans);
    }
    public static int rangeBitwiseAnd(int left, int right){
        int shifts = 0; 
        while(left != right){
            left = left >> 1;
            right = right >> 1;
            shifts++;
        }
        return left << shifts;
    }
}
