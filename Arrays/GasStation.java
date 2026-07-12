package Arrays;

public class GasStation{
    public static void main(String args[]){
        int gas[] = {1,2,3,4,5};
        int cost[] ={3,4,5,1,2};
        int answer = canCompleteCircuit(gas,cost);
        System.out.println(answer);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost){
        // int tank = 0;
        // int index = 0;
        // int n = gas.length;
        // for(int i = 0; i<n; i++){
        //     int current = i;
        //     tank = gas[current];
        //     while (true) {
        //         if (tank < cost[current])
        //             break;
        //         tank -= cost[current];
        //         current = (current + 1) % n;
        //         if (current == i)
        //             return i;
        //         tank += gas[current];
        //     }
        // }
        // return -1;

        //optimal greedy approach
        int total = 0;
        int start = 0;
        int tank = 0;
        for(int i = 0; i<gas.length; i++){
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
