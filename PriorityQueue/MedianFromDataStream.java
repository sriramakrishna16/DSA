package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

//problem, we have to find the median values of the data that is given as a stream
// so , we have take each elemet from stream and find median

//solution done by using minHeap and maxHeap and balances the position for every element
//if nums are odd , right side that is maxHeap is managed to maintain one extra elemnet than min,
//   so simply we return maxHeap.peek()

//if nums are even , then minHeap.peek + maxHeap.peek / 2.0

public class MedianFromDataStream {
    private static PriorityQueue<Integer> minHeap;
    private static PriorityQueue<Integer> maxHeap;

    public MedianFromDataStream(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    public static void main(String args[]){
        int [] nums = {5,2,8,10,3,7,1};
        MedianFromDataStream m = new MedianFromDataStream();
        for(int num : nums){
            MedianFromDataStream.addNum(num);
            System.out.println(MedianFromDataStream.findMedian());
        }
    }

    public static void addNum(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public static double findMedian(){
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }

}
