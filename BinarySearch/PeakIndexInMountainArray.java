public class PeakIndexInMountainArray {
    public static void main(String [] args){
        int [] arr = {0,10,5,2};
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);
        System.out.println("value is : " + arr[ans]);
    }
    public static int peakIndexInMountainArray(int [] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
