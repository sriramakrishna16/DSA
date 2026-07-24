import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String args[]){
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String bank [] = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        int ans = minMutations(startGene, endGene , bank);
        System.out.println(ans);
    }
    public static int minMutations(String startGene, String endGene, String[] bank){
        HashSet<String> set = new HashSet<>();
        for(String gene : bank){
            set.add(gene);
        }
        if(!set.contains(endGene)){
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        q.offer(startGene);
        visited.add(startGene);

        int mutations = 0;

        char[] ch = {'A','C','G','T'};

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                if(curr.equals(endGene)){
                    return mutations;
                }
                char [] gene = curr.toCharArray();
                for(int i = 0 ; i < gene.length ; i++){
                    char original = gene[i];
                    for(char c : ch){
                        if(c == original){
                            continue;
                        }
                        gene[i] = c;
                        String next = new String(gene);
                        if(set.contains(next) && !visited.contains(next)){
                            visited.add(next);
                            q.offer(next);
                        }  
                    }
                    gene[i] = original;
                }
            }
            mutations++;
        }
        return -1;
    }
}
