public class ValidPerfectSquare{
    public static void main(String [] args){
        int num = 16;
        boolean ans = isPerfectSquare(num);
        System.out.println(ans);
    }
    public static boolean isPerfectSquare(int num){
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