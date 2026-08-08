package Queue;

import java.util.LinkedList;
import java.util.Queue;

//problem , to implement the recentcount class within a certain time frame which is 3000 ms
// if ping is 2, mean we have to return counter or timestamps with in range
// like 2-3000 , 2998 - 2 which is 3000ms
// and we have to return the timestamps in between them..

public class NumberOfRecentCalls {
    Queue<Integer> q;
    NumberOfRecentCalls(){
        q = new LinkedList<>();
    }

    public int ping(int t){
        q.offer(t);
        while(q.peek() < t-3000){
            q.poll();
        }
        return q.size();
    }

    public static void main(String [] args){
        NumberOfRecentCalls n = new NumberOfRecentCalls();
        System.out.println(n.ping(1));
        System.out.println(n.ping(100));
        System.out.println(n.ping(3001));
        System.out.println(n.ping(3002));
    }
}
