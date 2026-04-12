package BitManipulations;

//Problem : Count no of 1 in each i and return array of size number + 1, 
// where i is iteration of number, from 0 to number.

public class CountingBits {
    public static void main(String args[]){
        int num = 5;
        int [] result = findOnesinEachI(num);
        for(int i : result){
            System.out.print( i + " ");
        }
    }

    public static int[] findOnesinEachI(int num){
        int [] answer = new int [num + 1];
        for(int i = 0; i <= num ; i++){
            int current = i;
            int count = 0;
            while(current != 0){
                current = current & (current - 1);
                count++;
            }
            answer[i] = count;
        }
        return answer;
    }

    //more optimised approach

    // public static int[] findOnesinEachI(int num){
    //     int [] answer = new int [num + 1];
    //     for(int i = 1; i <= num; i++){
    //         answer[i] = answer[i & (i -1)] + 1; //we use previous value without iterating
    //     }
    //     return answer;
    // }
    
}
