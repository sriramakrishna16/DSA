package Queue;

import java.util.LinkedList;
import java.util.Queue;

//problem , given a string contains only R and D which represents the Radiant and Dire parties where each index
// represent the senators(voters) 

//there are two rules 1 is the first senator can ban the rights of another party senator (he cant vote)
//  and another if there are no more opposite senators , he can announce the victory...!

public class Dota2Senate {
    public static void main(String [] args){
        String senate = "RRRRRDD";
        String victory = predict(senate);
        System.out.println(victory);
    }
    public static String predict(String senate){
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();
        for(int i = 0 ; i < n ; i++){
            if(senate.charAt(i) == 'R'){
                radiant.offer(i);
            }else{
                dire.offer(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            int r = radiant.poll();
            int d = dire.poll();
            if(r < d){
                radiant.offer(r+n);
            }else{
                dire.offer(d+n);
            }
        }
        return dire.isEmpty() ? "Radiant" : "Dire";
    }
}
