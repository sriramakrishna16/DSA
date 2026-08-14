package BinarySearch;

import java.util.Random;

class GuessGame {
    int secret;
    GuessGame(int n){
        secret = (int)(Math.random() * n)+1;
    }
    public int guess(int mid){
        if(mid == secret){
            return 0;
        }
        if(mid > secret){
            return -1;
        }
        return 1;
    }
}

public class GuessGameSolution extends GuessGame{
    GuessGameSolution(int n){
        super(n);
    }
    public int guessNumber(int n){
        int left = 0;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            int result = guess(mid);
            if(result == 0){
                return mid;
            }else if(result == -1){
                right = mid - 1;
            }else if(result == 1){
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int n = 10;
        GuessGameSolution s = new GuessGameSolution(n);
        int ans = s.guessNumber(n);
        System.out.println(s.secret);
        System.out.println(ans);
    }
}
