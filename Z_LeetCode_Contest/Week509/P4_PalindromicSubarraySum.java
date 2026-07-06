public class P4_PalindromicSubarraySum{

//problem , given an integer array so that we have to find the palindrome with max sum
// but we have run it in linear time

// generally palindrome require o(n^2) time
// so we used manachers algorithm to solve this in linear time.
    public static void main(String args[]){
        int nums [] = {7,3,2,1,2,3,7,4,5};
        long ans = maxPalindromeSum(nums);
        System.out.println(ans);
    }
   /*  public static long maxPalindromeSum(int [] nums){

        int n = nums.length;

        // prefix array for calculating the max sum.
        int [] pref = new int[n + 1];

        for(int i = 0; i<n; i++){
            pref[i + 1] = pref[i] + nums[i];
        }

        long ans = 0;

        if(n == 0) return 0;

        if(n == 1){
            ans = nums[0];
        }

        int [] odd = new int[n];

        int l = 0 , r = -1;

        //for odd length..

        for(int i = 0 ; i < n ; i++){
            int k;  //radius
            if(i > r){  // if r is unknown , then itself it has radius 1
                k = 1;
            }else{ //if not , then r is already in palindrome , so we find mirror
                int mirror = l + r - i;
                k = Math.min(odd[mirror], r - i + 1); //k must be inside palindrome , so we limit it by using right
            }

            while(i - k >= 0 && i + k < n && nums[i - k] == nums[i + k]){ //if equal , k++
                k++;
            }

            odd[i] = k;

            int left = i - k + 1;
            int right = i + k - 1;

            long sum = pref[right + 1] - pref[left];

            ans = Math.max(ans , sum);

            if(right > r){
                l = left;
                r = right;
            }
        }

        //for even length palindromes
        int[] even = new int[n];
        l = 0;
        r = -1;

        for(int i = 0; i < n; i++){
            int k; 
            if(i > r){
                k = 0;
            }else{
                int mirror = l + r - i + 1;
                k = Math.min(even[mirror], r - i + 1);
            }

            while(i - k - 1 >= 0 && i + k < n && nums[i - k - 1] == nums[i + k]){
                k++;
            }

            even[i] = k;

            if(k > 0){
                int left = i - k;
                int right = i + k - 1;
                long sum = pref[right+1]-pref[left];
                ans = Math.max(sum, ans);

                if(right > r){
                    l = left;
                    r = right;
                }
            }
        }
        return ans;

    } */
    public static long maxPalindromeSum(int [] nums){
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        long[] prefix = new long[n + 1];

        for(int i = 0 ; i < n ; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int m = 2 * n + 1;
        int [] newNums = new int[m];

        for(int i = 0; i<m ; i++){
            if(i % 2 == 0){
                newNums[i] = -1;
            }else{
                newNums[i] = nums[i / 2];
            }
        }

        int odd [] = new int[m];

        int l = 0;
        int r = -1;

        long ans = 0;

        for(int i = 0 ; i < m ; i++){
            int k;
            if(i > r){
                k = 1;
            }else{
                int mirror = l + r - i;
                k = Math.min(odd[mirror], r - i + 1);
            }

            while(i - k >= 0 && i + k < m && newNums[i - k] == newNums[i + k]){
                k++;
            }

            odd[i] = k;

            int leftT = i - k + 1;
            int rightT = i + k - 1;

            int left = leftT/2;
            int right = (rightT - 1)/2;

            if (left <= right) {
                long sum = prefix[right + 1] - prefix[left];
                ans = Math.max(ans, sum);
            }

            if(rightT > r){
                l = leftT;
                r = rightT;
            }
        }
        return ans;
    }
}