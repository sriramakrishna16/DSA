//problem , implement the power function without using any inbuilt functions.
// direct for loop is very slow for large numbers

//so we decrese the power until it reaches 1 
// ex : 2^8 - > 2 ^ 4 ^2 - > (2^2)^2^2 ..... 


ublic class MyPow {
    public static void main(String args[]){
        double x = 2.0;
        int n = 8;
        double ans = myPow(x,n);
        System.out.println(ans);
    }
    public static double myPow(double x , int n){
        long power = n;
        if(power < 0){
            x = 1/x;
            power = -power;
        }
        double ans = 1.0;
        while(power > 0){
            if(power % 2 == 1){
                ans *= x;
            }
            x *= x;
            power /= 2;
        }
        return ans;
    }
}
