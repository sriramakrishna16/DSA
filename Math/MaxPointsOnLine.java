import java.util.*;

//problem, given 2D array of points represents x and y on graph
// we have to return the total number points that forms a straight line.

// we have to use slope formula y2 - y1 / x2 - x1 where all connected points have same slope

//solution done using hashmap to store slope and frquency from start point to remaining points. and 
// again take another start point to remainig points until the end.
// at final we got the maximum line points.

//while doing the calculation, we face several issues...
// we get divide by zero exception if it is zero
// we get assumed as not same line even points are on same line like 0,1 0,8 all are same line
//        -- if(x == 0) y = 1 or if(y == 0) x = 1 to maintain the hashmap accuracy.
// double is not recommended (may mismatch of very small point diff) , so we store as String
// - dy + "/" + dx . now suppose 2/4(int div not accepted) and 3/6 are same but hashmap assumes that are different
// so we use gcd of 2 and 4 is 2 so dx/2 and dy/2 so dy/dx is 1/2 and same for 3/6 too.

public class MaxPointsOnLine {
    public static void main(String args[]){
        int [][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int ans = maxPoints(points);
        System.out.println(ans);
    }
    public static int maxPoints(int[][] points){
        int n = points.length;
        if(n <= 2){
            return n;
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            HashMap<String,Integer> map = new HashMap<>();
            int max = 0;
            for(int j = i + 1 ; j < n ; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if(dx == 0){
                    dy = 1;
                }else if(dy == 0){
                    dx = 1;
                }else{
                    if(dx < 0){
                        dx = -dx;
                        dy = -dy;
                    }
                    int gcd = findGcd(Math.abs(dx),Math.abs(dy));
                    dx = dx/gcd;
                    dy = dy/gcd;
                }
                String slope = dx + "/" + dy;
                int count = map.getOrDefault(slope,0)+1;
                map.put(slope, count);
                max = Math.max(max , count);
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }
    public static int findGcd(int a , int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
