public class NearestAvailableDrone{
    public static void main(String  [] args){
        int [][] drones = {{0,0,8},{2,2,9}};
        int [] target = {3,4};
        int index = nearestDrone(drones, target);
        System.out.println(index);
    }
    public static int nearestDrone(int[][] drones, int [] target){
        int minDistance = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0 ; i < drones.length ; i++){
            int x = drones[i][0];
            int y = drones[i][1];
            int dist = Math.abs(x-target[0]) + Math.abs(y-target[1]);
            if(dist <= drones[i][2]){
                if(dist < minDistance){
                    ans = i;
                    minDistance = dist;
                }
            }
        }
        return ans;
    }
}