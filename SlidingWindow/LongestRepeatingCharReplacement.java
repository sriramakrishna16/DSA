package SlidingWindow;

public class LongestRepeatingCharReplacement {
    public static void main(String [] args){
        // AABABBA
        String str = "aababba";
        int k = 1;
        int max = findMax(str, k);
        System.out.println(max);
    }

    //a,a,b,a
    public static int findMax(String str , int k){
        int left = 0;
        int max = 0;
        int maxFreq = 0;
        String cap = str.toUpperCase();
         
        int [] count = new int [26];
        for(int right = 0; right<cap.length(); right++){
            int idc = cap.charAt(right) - 'A';
            count[idc]++;
            maxFreq = Math.max(maxFreq,count[idc]);

            
            while(((right-left + 1)-maxFreq)>k){
                count[cap.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max,right-left + 1);
        }

        return max;
    }
}
