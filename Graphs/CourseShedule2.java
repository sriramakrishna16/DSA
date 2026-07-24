import java.util.*;

public class CourseShedule2 {
    public static void main(String args[]){
        int numCourses = 4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int [] ans = order(numCourses, prerequisites);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] order(int numCourses , int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];
            graph.get(prerequisite).add(course);
        }
        int state[] = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            if(state[i] == 0){
                if(dfs(i, graph, state , ans)){
                    return new int[]{};
            }
            }
        }
        int a[] = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            a[numCourses - i - 1] = ans.get(i); 
        }
        return a;
    }
    public static boolean dfs(int node , List<List<Integer>> graph , int [] state, List<Integer> ans){
        if(state[node] == 1) return true;
        if(state[node] == 2) return false;
        state[node] = 1;
        for(int neigh : graph.get(node)){
            if(dfs(neigh, graph, state, ans)){
                return true;
            }
        }
        state[node]= 2;
        ans.add(node);
        return false;
    }
}
