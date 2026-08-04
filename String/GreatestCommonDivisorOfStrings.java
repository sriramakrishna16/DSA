public class GreatestCommonDivisorOfStrings {
    public static void main(String args[]){
        String a = "ABABAB";
        String b = "ABAB";
        String ans = gcdOfStrings(a,b);
        System.out.println(ans);
    }
    public static String gcdOfStrings(String a, String b){
        if(a.length() == 0 || b.length() == 0) return "";
        if(!(a+b).equals(b+a)) return "";
        int gcd = findGCD(a.length(), b.length());
        return a.substring(0,gcd);
    }
    private static int findGCD(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
