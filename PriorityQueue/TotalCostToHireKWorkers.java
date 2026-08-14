import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public static void main(String [] args){
        int [] costs = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        long ans = totalCost(costs, k, candidates);
        System.out.println(ans);
    }

    public static long totalCost(int[] costs, int k , int candidates){
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int n = costs.length;
        int l = 0;
        int r = n-1;
        for(int i = 0 ; i < candidates && l <= r; i++){
            pq1.offer(costs[l]);
            l++;
        }
        for(int i = 0 ; i < candidates && l <= r; i++){
            pq2.offer(costs[r]);
            r--;
        }
        long total = 0;
        for(int i = 0 ; i < k ; i++){
            if(pq2.isEmpty() || (!pq1.isEmpty() && pq1.peek() <= pq2.peek())){
                total += pq1.poll();
                if(l <= r){
                    pq1.offer(costs[l]);
                    l++;
                }
            }else{
                total += pq2.poll();
                if(l <= r){
                    pq2.offer(costs[r]);
                    r--;
                }
            }
        }
        return total;
    }
}
