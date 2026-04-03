package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures{
    public static void main(String args[]){
        int [] temperatures = {73,74,75,71,69,72,76,73};
        int [] result = dailyTemp(temperatures);
        for(int i : result){
            System.out.print(i);
        }
    }
    public static int[] dailyTemp(int[] temperatures){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int [temperatures.length];
        for(int temp = 0;temp<temperatures.length;temp++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[temp]){
                int prev = stack.pop();
                result[prev] = temp - prev;
            }
            stack.push(temp);
        }

        return result;
    }
}

