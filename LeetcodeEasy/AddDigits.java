package EasyProblems;

public class AddDigits {
    public static void main(String args[]){
        int num = 12345;
        int ans = add(num);
        System.out.println(ans);
    }
    public static int add(int num){
        // while(num >= 10){
        //     int sum = 0;
        //     while(num > 0){
        //         sum += num % 10;
        //         num /= 10;
        //     }
        //     num = sum;
        // }
        // return num;
        
        //without loop
        if(num == 0) return 0;
        if(num % 9 == 0) return 9;
        else return num % 9;
    }
}
