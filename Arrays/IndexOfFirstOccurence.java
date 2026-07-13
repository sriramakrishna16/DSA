package Arrays;

public class IndexOfFirstOccurence {
    public static void main(String args[]){
        String haystack = "butsadsad";
        String needle = "sad";
        int ans = findOccurence(haystack,needle);
        System.out.println(ans);
    }
    public static int findOccurence(String hayString, String needle){
        int h = hayString.length();
        int n = needle.length();
        if(n > h) return -1;
        
        for(int start = 0; start <= h-n; start++){
            int j = start;
            int i = 0;
            while(i < n && hayString.charAt(j) == needle.charAt(i)){
                i++;
                j++;
            }
            if(i == n) return start;
        }
        return -1;
    }
}
