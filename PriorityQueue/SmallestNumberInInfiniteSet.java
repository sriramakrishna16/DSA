package PriorityQueue;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
    PriorityQueue<Integer> q;
    HashSet<Integer> set;
    int next;
    public SmallestNumberInInfiniteSet(){
        q = new PriorityQueue<>();
        set = new HashSet<>();
        next = 1;
    }
    public int popSmallest() {
        if (!q.isEmpty()) {
            int smallest = q.poll();
            set.remove(smallest);
            return smallest;
        }
        return next++;
    }
    public void addBack(int num) {
        if (num < next && !set.contains(num)) {
            q.offer(num);
            set.add(num);
        }
    }
    public static void main(String[] args) {
        SmallestNumberInInfiniteSet obj = new SmallestNumberInInfiniteSet();
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        obj.addBack(1);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest()); 
        obj.addBack(2);
        System.out.println(obj.popSmallest()); 
        System.out.println(obj.popSmallest());
    }
}
