package Graphs;

import java.util.ArrayList;
import java.util.List;

//problem given a list of cources of prerequisites mean , a cource should be only take if prerequisite 
// is completed. {1,0} 1 should be taken only if o completed , mean 1 has prerequisite 0
//if no cycle found mean cources are completed
//if cycle found cources are impossible to complete 
//example {1,0}{0,1} - 1 - 0(complete?) : 0- 1(complete?) loop. return false

public class CourseShedule {
    public static void main(String args[]){
        int numCourse = 2;
        int [][] prerequisites = {{1,0},{0,1}};
        boolean ans = isSheduled(numCourse, prerequisites);
        System.out.println(ans);
    }
    public static boolean isSheduled(int numCourse, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();

        //inserting empty lists
        for(int i = 0 ; i < numCourse ; i++){
            graph.add(new ArrayList<>());
        }

        //creating graph
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];
            graph.get(prerequisite).add(course);
        }

        //initialising state for detecting cycles
        int [] state = new int[numCourse];

        for(int i = 0 ; i < numCourse ; i++){
            if(state[i] == 0){
                if(dfs(i,graph,state)){
                    return false;
                }
            }
        }
        return true;
    }

    //dfs returns true if cycle detects
    public static boolean dfs(int node, List<List<Integer>> graph, int[] state){
        if(state[node] == 1){
            return true;
        }

        if(state[node] == 2){
            return false;
        }


        state[node] = 1;

        for(int neigh : graph.get(node)){
            if(dfs(neigh, graph, state)){
                return true;
            }
        }

        state[node] = 2;

        return false;
    }
}
