package PriorityQueue;

import java.util.*;

//problem , given an integer array
// we have to return k elements which are more frequent in array

//we use priorityqueue to find the most frequent elements 
//and we can store frequent elemets in array and return

public class TopKFrequentElements {
    public static void main(String args[]){
        int [] arr = {1,1,1,2,2,3};
        int k = 2;
        int [] ans = findElements(arr, k);
        for(int x : ans){
            System.out.print(x + " ");
        }
    }
    public static int[] findElements(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for(int i = k - 1; i>=0 ; i--){
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}
