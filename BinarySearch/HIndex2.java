public class HIndex2 {
    public static void main(String [] args){
        int [] citations = {0,1,3,5,6};
        int ans = hIndex(citations);
        System.out.println(ans);
    }
    public static int hIndex(int [] citations){
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int papers = n - mid;
            if (citations[mid] >= papers) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
