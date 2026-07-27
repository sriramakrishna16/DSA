package BinarySearch;

//problem . given two sorted arrays of nums and we have to return the median of two
// - sorted arrays in O(log (m + n)) time , so we must use binarysearch.

//solution is we apply binary search on only one array(nums1) and apply partitioningthe  two arrays into four parts
// left1, right1 , left2 , right2.

//always we have to maintain the smaller array for binary search (nums1) and after applying bs
// - cut into two halves of nums1 and also cut nums2 into two halves based on cut1
//example :
//total elements of nums1 and nums2 is 11(odd) , then we maintain atlleast left1 and left2 contains 6 elements
// beacuse 6th element will be the median. if even left + right /2 will be median

// if cut1 make nums1 of left1 elements -> 4, then in nums2 of left2 has only 2 elements
// and we maintain 6 elements and then now we compare the left1 and right2 , left2 and right1
//if(left1 <= right2 and same for left2 and right2) then left and right parts are prefect.
//if not . if(left1 > right2) then we have bigger elements in left side , so we move cut1 to left
// else cut to right.

//note we dont compare left1 and right1 because they already sorted..!

//simple example  

//  1,3,5,9,15 and 7,8,16,17,19,20
// 1,3 | 5 9 15
// 7,8,16,17 | 19 20
// 17 is in left side and greater than right(5) so move cut to 9
//16 also grater than 9 so move cut to right(15)...
// then
// 1,3,5,9 | 15
// 7,8 | 16,17,19,20  now observe that left and right are perfect and 9 is median

public class MedianOfTwoSortedArrays {
    public static void main(String args[]){
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        double ans = findMedian(nums1, nums2);
        System.out.println(ans);
    }
    public static double findMedian(int [] nums1, int [] nums2){
        if(nums1.length > nums2.length){
            return findMedian(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        
        int low = 0; 
        int high = m;

        while(low <= high){
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1)/2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];

            if(left1 <= right2 && left2 <= right1){
                if((m + n) % 2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1,right2))/2.0;
                }
                return Math.max(left1, left2);
            }
            else if(left1 > right2){
                high = cut1 - 1;
            }
            else{
                low = cut1 + 1;
            }
        }
        return -1;
    }
}
