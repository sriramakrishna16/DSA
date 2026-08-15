package BinarySearch;

public class KokoEatingBananas {
    public static void main(String [] args){
        int [] piles = {30,11,23,4,20};
        int h = 5;
        int eatingSpeedPerHour = minEatingSpeed(piles, h);
        System.out.println(eatingSpeedPerHour);
    }
    public static int minEatingSpeed(int[] piles, int h){
        int left = 1;
        int right = 0;
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        while(left < right){
            int mid = left + (right - left)/2;
            long hours = 0;
            for(int pile : piles){
                hours += (pile + mid - 1)/mid;
            }
            if(hours <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
