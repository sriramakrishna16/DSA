import java.util.ArrayList;
import java.util.List;

//problem , given an 2D array with length 2 that points one node to another node which
// represents the road from one city to another city.
// we have to make all the paths traverse to node 0. and return the no of paths changed to make all paths connected
// to zero.

//solution for every path mark original as 1 and reverse as 0 . 
//because we traverse from 0 to end in reverse traversal , if dfs path is reverse to original, no increment done to count.
// else if original path matches with dfs path we have to change the path , so increment the count.

public class ReorderRoutesToMakePath{
    public static void main(String[] args){
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 6;
        int ans = minReorder(connections,n);
        System.out.println(ans);
    }
    public static int minReorder(int[][] connections, int n){
        int m = connections.length;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : connections){
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }
        boolean [] visited = new boolean[n];
        return dfs(0,graph,visited);
    }
    public static int dfs(int node, List<List<int[]>> graph, boolean [] visited){
        visited[node] = true;
        int count = 0;
        for(int [] edge : graph.get(node)){
            int next = edge[0];
            int needReverse = edge[1];
            if(visited[next]){
                continue;
            }
            count += needReverse;
            count += dfs(next, graph, visited);
        }
        return count;
    }
}