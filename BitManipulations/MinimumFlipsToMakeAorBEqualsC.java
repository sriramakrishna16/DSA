public class MinimumFlipsToMakeAorBEqualsC {
    public static void main(String [] args){
        int a = 4;
        int b = 2;
        int c = 7;
        int ans = minFlips(a,b,c);
        System.out.println(ans);
    }
    public static int minFlips(int a , int b, int c){
        int flips = 0;
        for(int i = 0 ; i < 32 ; i++){
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int cBit = (c >> i) & 1;
            if(cBit == 0 && (aBit == 1 || cBit == 1)){
                flips += aBit + bBit;
            }
            if(cBit == 1 && (aBit == 0 && bBit == 0)){
                flips++;
            }

            // simple logic
            // if(cBit == 0){
            //     flips += aBit + bBit;
            // }else{
            //     if(aBit == 0 && bBit == 0){
            //         flips++;
            //     }
            // }
        }
        return flips;
    }
}
