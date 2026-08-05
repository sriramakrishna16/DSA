//problem , given array of chars
// we have to compress and return the length like if a,a,a then a,3

public class StringCompression {
    public static void main(String[] args){
        char [] ch = {'a','a','b','b','c','c','c'};
        int ans = compress(ch);
        System.out.println(ans);
    }

    public static int compress(char [] ch){
        // StringBuilder sb = new StringBuilder();
        // for(int i = 0; i < ch.length ; i++){
        //     int count = 1;
        //     char curr = ch[i];
        //     while(i < ch.length - 1 && curr == ch[i+1]){
        //         count++;
        //         i++;
        //     }
        //     if(count > 1)
        //         sb.append(curr).append(count);
        //     else
        //         sb.append(curr);
        // }
        // return sb.length();

        //space optimised code
        int write = 0;
        int read = 0;
        while(read < ch.length){
            char curr = ch[read];
            int count = 0;
            while(read < ch.length && ch[read] == curr){
                count++;
                read++;
            }
            ch[write++] = curr;
            if(count > 1){
                String str = Integer.toString(count);

                for (char c : str.toCharArray()) {
                    ch[write++] = c;
                }
            }
        }
        return write;
    }
}
