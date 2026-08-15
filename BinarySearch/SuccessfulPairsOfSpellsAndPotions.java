package BinarySearch;
import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public static void main(String [] args){
        int [] spells = {3,1,2};
        int [] potions = {8,5,8};
        int success = 16;
        int[] ans = successfullPairs(spells, potions, success);
        for(int a : ans){
            System.out.print(a + " ");
        }
    }
    public static int[] successfullPairs(int [] spells , int [] potions, int success){
        Arrays.sort(potions);
        int [] ans = new int[spells.length];
        int i = 0;
        for(int s : spells){
            int left = 0;
            int right = potions.length -1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if((long)potions[mid] * s >= success){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            ans[i] = potions.length - left;
            i++;
        }
        return ans;
    }
}
