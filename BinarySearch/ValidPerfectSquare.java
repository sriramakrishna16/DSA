//return true if the num is perfect square

public class ValidPerfectSquare{
    public static void main(String [] args){
        int num = 9;
        boolean ans = isPerfectSquare(num);
        System.out.println(ans);
    }
    public static boolean isPerfectSquare(int num){
        //using square root function
        // double ans = Math.sqrt(num);
        // if(ans == (int)ans) return true;
        // return false;

        // without using squareroot function
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = left +(right - left)/2;
            long ans = (long) mid * mid;
            if(ans == num){
                return true;
            }else if(ans < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}