import java.util.Arrays;
public class FindRightInterval {
    public static void main(String [] args){
        int [][] intervals = {{3,4},{2,3},{1,2}};
        int [] ans = findRightInterval(intervals);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] findRightInterval(int[][] intervals){
        int n = intervals.length;
        int [][] copy = new int[n][2];
        for(int i =0 ; i < intervals.length; i++){
            copy[i][0] = intervals[i][0];
            copy[i][1] = i;
        }
        Arrays.sort(copy,(a,b) -> a[0] - b[0]);
        int [] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            int target = intervals[i][1];
            int left = 0;
            int right = n-1;
            int index = -1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(copy[mid][0] >= target){
                    index = copy[mid][1];
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            ans[i] = index;
        }
        return ans;
    }
}
