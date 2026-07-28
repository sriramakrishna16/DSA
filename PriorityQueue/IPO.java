package PriorityQueue;

import java.util.PriorityQueue;

//problem , given arrays of capitals and profits , and initially profit w = 0, we use w to invest in capital
// and algo given k that represents no of projects we have to take

//return the maximum capital by chosing the best k projects.

//solution using min heap priority queue for selecting low capital projects and maxHeap for selecting the
// highest returning profits...

public class IPO {
    public static void main(String args[]){
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capitals = {0,1,1};
        int ans = findMaximizedCapital(k,w,profits,capitals);
        System.out.println(ans);
    }
    public static int findMaximizedCapital(int k , int w, int[] profits, int[] capitals){
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0 ; i < capitals.length ; i++){
            minHeap.offer(new int[]{capitals[i],profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.offer(minHeap.poll()[1]);
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
        return w;
    }
}
