package LeetcodeDailyStreak.java;

public class SortedGCDPairQueries {
    public static void main(String args[]){
        int nums [] = {2,3,4};
        int [] queries = {0,2,2};
        int [] ans = gcdValues(nums, queries);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] gcdValues(int[] nums, int[] queries){
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] exact = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long cnt = 0;
            for (int m = g; m <= max; m += g)
                cnt += freq[m];

            exact[g] = cnt * (cnt - 1) / 2;

            for (int m = g * 2; m <= max; m += g)
                exact[g] -= exact[m];
        }

        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++)
            prefix[g] = prefix[g - 1] + exact[g];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = 1, r = max;
            while (l < r) {
                int mid = (l + r) / 2;
                if (prefix[mid] > queries[i])
                    r = mid;
                else
                    l = mid + 1;
            }
            ans[i] = l;
        }

        return ans;
    }
}
