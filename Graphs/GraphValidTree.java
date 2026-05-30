import java.util.*;

//problem : given nodes which ranges from 0 to n-1 and list of edges. which are undirected
//mean , if edge is given 0, 1 then 0 - 1 and 1 - 0 is possible.
//by using nodes and edges we have to form graph and check its valid or any cycles forms.
//if cycle forms return false or else return true

public class GraphValidTree {
    public static void main(String args[]){
        int n = 5;
        int [][] edges = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };
        boolean result = validTree(n, edges);
        System.out.println(result);
    }
    public static boolean validTree(int n, int[][] edges){

        if(edges.length != n - 1){
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int first = edge[0];
            int second = edge[1];
            
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        Set<Integer> visited = new HashSet<>();

        if(dfs(0,-1, visited, graph)){
            return false;
        }

        return visited.size() == n;

    }
    public static boolean dfs(int node, int parent, Set<Integer> visited , List<List<Integer>> graph){

        if(visited.contains(node)){
            return true;
        }

        visited.add(node);

        for(int neighbor : graph.get(node)){

            if(neighbor == parent){
                continue;
            }

            if(dfs(neighbor, node, visited, graph)){
                return true;
            }
        }

        return false;
    }
}
