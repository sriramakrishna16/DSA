import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

//problem given a undirected edges of nodes from 0 to n-1
//after building graph , find the total no of components
//component mean a group of nodes which is seperated from another group, no connection b/w them.
//ex : 1-2-3   5-6  two components return 2

public class NumberOfConnectedComponents {
    public static void main(String args[]){
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4},{2,3}};
        int ans = Components(n, edges);
        System.out.println(ans);
    }
    public static int Components(int n , int[][] edges){
        //intializing graph for all undirected edges
        List<List<Integer>> graph = new ArrayList<>();

        boolean [] visited = new boolean[n];

        //initializing empty graph for each node
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        //building graph in undirectional
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;
        
        //traversing each node using dfs and marks true for every related component in single time.
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == false){
                count += 1;
                dfs(i, visited, graph); // 0,1  1,2  3,4 
            }
        }

        return count;
    }
    public static void dfs(int node , boolean[] visited, List<List<Integer>> graph){

        visited[node] = true;

        for(int neighbor: graph.get(node)){

            if(visited[neighbor] == true){
                continue;
            }

            dfs(neighbor, visited, graph);

        }

    }
}
