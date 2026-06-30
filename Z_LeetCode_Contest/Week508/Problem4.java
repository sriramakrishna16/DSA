import java.util.*;

//problem, Minimum Time to Reach Target With Limited Power
// we given n nodes and its edges and cost , and max power
// also given source and target

//we have to reach the target by using minimum time and maximum remaining power.
//we use dijkstra's algorithm to solve this problem.
//by using priority queue we keep the state with smallest time.

public class Problem4{
    public static void main(String args[]){
        int n = 5;
        int [][] edges = {{0,1,1},{1,4,1},{0,2,1},{2,3,1},{3,4,1}};
        int power = 4;
        int [] cost ={2,3,1,1,1};
        int source = 0;
        int target = 4;
        long [] ans = minTimeMaxPower(n,edges,power, cost, source, target);
        for(long i : ans){
            System.out.println(i);
        }
    }
    public static class Edge{
        int to;
        int time;
        Edge(){};
        Edge(int to,int time){
            this.to = to;
            this.time = time;
        }
    }

    public static class State{
        int node;
        int power;
        long time;
        State(){};
        State(int node,int power,long time){
            this.node = node;
            this.power = power;
            this.time = time;
        }
    }

    public static long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target){
        if(source == target){
            return new long[]{0L,power};
        }

        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int [] e : edges){
            graph[e[0]].add(new Edge(e[1],e[2]));
        }

        long[][] dist = new long[n][power+1];

        long INF = Long.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dist[i],INF);
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));

        dist[source][power] = 0;

        pq.offer(new State(source, power, 0));

        while(!pq.isEmpty()){
            State curr = pq.poll();

            if (curr.time != dist[curr.node][curr.power]) {
                continue;
            }

            if (curr.power < cost[curr.node]) {
                continue;
            }

            int nextPower = curr.power - cost[curr.node];

            for(Edge edge : graph[curr.node]){
                long nextTime = curr.time + edge.time;
                if(nextTime < dist[edge.to][nextPower]){
                    dist[edge.to][nextPower] = nextTime;
                    pq.offer(new State(edge.to, nextPower, nextTime));
                }
            }
        }

        long bestTime = INF;
        long bestPower = -1;

        for(int p = 0; p <= power; p++){
            if(dist[target][p] < bestTime){
                bestTime = dist[target][p];
                bestPower = p;
            }else if(dist[target][p] == bestTime && p > bestPower){
                bestPower = p;
            }
        }

        if(bestTime == INF){
            return new long[]{-1L,-1L};
        }

        return new long[]{bestTime,bestPower};
    }
}