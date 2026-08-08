package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//problem , given array of numbers which denotes the size of asteriod and sign denotes the direction 
// + moves rght , - moves left on from particualr pos , if both directions collides , smaller one explodes

public class AsteriodCollision {
    public static void main(String [] args){
        int [] asteroids = {10,-5,5,-7};
        int[] ans = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ans)); 
    }
    public static int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for(int curr : asteroids){
            boolean alive = true;
            while(alive && curr < 0 && !stack.isEmpty() && stack.peek() > 0){
                if (stack.peek() < -curr) {
                    stack.pop();
                }
                else if (stack.peek() == -curr) {
                    stack.pop();
                    alive = false;
                }
                else {
                    alive = false;
                }
            }
            if(alive){
                stack.push(curr);
            }
        }
        int[] ans = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }
        return ans;
    }
}
