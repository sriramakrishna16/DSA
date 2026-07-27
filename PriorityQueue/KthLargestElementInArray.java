package PriorityQueue;
import java.util.PriorityQueue;

//problem , given an integer array where we have to return kth largest element
// we can do it by using priority queue where smaller elements are removed first

public class KthLargestElementInArray {
    public static void main(String args[]){
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        int ans = findKthLargest(nums, k);
        System.out.println(ans);
    }

    public static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int num : nums){
            p.offer(num);
            if(p.size() > k){
                p.poll();
            }
        }
        return p.peek();
    }
}
