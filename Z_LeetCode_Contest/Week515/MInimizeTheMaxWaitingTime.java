package Z_LeetCode_Contest.Week515;

public class MinimizeTheMaxWaitingTime {
    public static void main(String [] args){
        int period = 8;
        int [] lights = {2,3};
        int[] arrivalTime = {2,5,8,11};
        int ans = minPenality(period,lights,arrivalTime);
        System.out.println(ans);
    }
    public static int minPenality(int period, int[] lights, int [] arrivalTime){
        int maxLight = 0;
        for(int light : lights){
            maxLight = Math.max(maxLight, light);
        }
        int maxWaitingTime = 0;
        for(int t : arrivalTime){
            int r = t % period;
            if(r >= maxLight){
                int waitingTime = period - r;
                if(waitingTime > maxWaitingTime){
                    maxWaitingTime = waitingTime;
                }
            }
        }
        return maxWaitingTime;
    }
}
