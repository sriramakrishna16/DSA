import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubSequenceScore{
    public static void main(String [] args){
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        long ans = maxScore(nums1, nums2, k);
        System.out.println(ans);
    }
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for (int[] pair : pairs) {
            int num2 = pair[0];
            int num1 = pair[1];
            minHeap.offer(num1);
            sum += num1;
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                ans = Math.max(ans, sum * num2);
            }
        }
        return ans;
    }
}