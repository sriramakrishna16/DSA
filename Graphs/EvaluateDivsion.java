import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivsion {
    public static void main(String args[]){
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"),Arrays.asList("b", "c"));
        double [] values = {2.0,3.0};
        List<List<String>> queries =  Arrays.asList(Arrays.asList("a", "c"),Arrays.asList("b", "a"),Arrays.asList("a", "e"),
                                                    Arrays.asList("a", "a"),Arrays.asList("x", "x"));

        double ans[] = evaluate(equations,values, queries);
        System.out.println(Arrays.toString(ans));
    }
    public static double[] evaluate(List<List<String>> equations, double [] values, List<List<String>> queries){
        //desiging graph
        Map<String, Map<String,Double>> graph = new HashMap<>();
        for(int i = 0 ; i < equations.size() ; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            
            graph.putIfAbsent(u , new HashMap<>());
            graph.putIfAbsent(v , new HashMap<>());
            double value = values[i];
            graph.get(u).put(v,value);
            graph.get(v).put(u,1.0/value);
        }
        double ans [] = new double [queries.size()]; 
        for(int i = 0 ; i < queries.size() ; i++){
            String curr = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            if(!graph.containsKey(curr) || !graph.containsKey(target)){
                ans[i] = -1;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            ans[i] = dfs(curr, target, graph, visited, 1.0);
        }
        return ans;
    }
    public static double dfs(String curr, String target, Map<String , Map<String, Double>> graph, HashSet<String> visited, double product){
        if(curr.equals(target)){
            return product;
        }
        visited.add(curr);
        for(Map.Entry<String, Double> entry : graph.get(curr).entrySet()){
            String next = entry.getKey();
            double weight = entry.getValue();
            if(!visited.contains(next)){
                double ans = dfs(next, target, graph, visited, product * weight);
                if(ans != -1.0){
                    return ans;
                }
            } 
        }
        return -1.0;
    }
}
