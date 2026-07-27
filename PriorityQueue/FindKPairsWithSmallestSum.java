package PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {
    public static void main(String args[]){
        int nums1[] = {1,7,11};
        int nums2[] = {2,4,6};
        int k = 3;
        List<List<Integer>> ans = kSmallestPairs(nums1, nums2, k);
        System.out.println(ans);
    }

    public static List<List<Integer>> kSmallestPairs(int nums1[], int nums2[], int k){
        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return ans;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{
                    nums1[i] + nums2[0],
                    i,
                    0
            });
        }

        while (!pq.isEmpty() && k-- > 0) {

            int[] cur = pq.poll();

            int row = cur[1];
            int col = cur[2];

            ans.add(Arrays.asList(nums1[row], nums2[col]));

            if (col + 1 < nums2.length) {
                pq.offer(new int[]{
                        nums1[row] + nums2[col + 1],
                        row,
                        col + 1
                });
            }
        }

        return ans;
    }
}
