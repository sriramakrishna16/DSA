import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    public static void main(String [] args){
        int [] arr = {1,1,2,3,4,5};
        int k = 4;
        int x = 3;
        List<Integer> ans = findClosestElement(arr,k,x);
        System.out.println(ans);
    }
    public static List<Integer> findClosestElement(int [] arr, int k , int x){
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
