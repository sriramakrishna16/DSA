package Z_LeetCode_Contest.Week519;

public class CountShadowPairs1 {
    public static void main(String [] args){
        int [] nums = {3,1,4,1,5};
        long ans = shadowPairs(nums);
        System.out.println(ans);
    }

    public static long shadowPairs(int [] nums){
        long res = 0;
        int[] s = new int[nums.length];
        int k = 0;
        for (int a : nums) {
            while (k > 0 && s[k - 1] > a) {
                k--;
            }
            int l = 0, r = k;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (s[mid] < a)
                    l = mid + 1;
                else
                    r = mid;
            }
            res += l;
            s[k++] = a;
        }
        return res;
    }
}
