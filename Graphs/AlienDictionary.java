import java.util.*;


//problem , given a dictionary words in order that refers to alien context but same letters 
// we know , dictionary words are arranged in order , like an, ant , any...
//in this way , alien words also give wrt, wrf
// so the logic is we compare the words and at first differ , we decide 1st char comes before 2nd like t -> f
//in this way, we have to find the order of words.

// i am using graphs and topological sorting. 

public class AlienDictionary {
    public static void main(String[] args) {

        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        String answer = alienOrder(words);
        System.out.println("Alien Dictionary Order: " + answer);
    }

    public static String alienOrder(String[] words) {

        //initialising graph , using Set in place of value , because many time words repeated
        //so set helps to avoid duplicates.
        //using indegree for topological sorting based on edges
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        int len = words.length;

        //initializing all chars in graph and indegree
        for(String word : words){
            for(char ch : word.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        //building graph
        for(int i = 0 ; i < len - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];

            //usually in dict , ant -> an is wrong order , completely false dict
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }

            int minLen = Math.min(word1.length(), word2.length());

            for(int j = 0 ; j < minLen ; j++){
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if(ch1 != ch2){
                    if(!graph.get(ch1).contains(ch2)){
                        graph.get(ch1).add(ch2);
                        indegree.put(ch2,indegree.get(ch2) + 1);
                    }
                    //we have to end here bec , in dict , abyz and abza 
                    //after ab match , y z differ so y -> z and there is no gurantee that z -> a
                    //beac dict is currently following order in first differ.
                    break;
                }
            }
        }

        //arranging all chars in order using topological sorting
        Queue<Character> queue = new LinkedList<>();

        for(char ch : indegree.keySet()){
            if(indegree.get(ch) == 0){
                queue.offer(ch);
            }
        }

        StringBuffer result = new StringBuffer();

        while(!queue.isEmpty()){
            char ch = queue.poll();

            result.append(ch);

            for(char neighbor : graph.get(ch)){
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }

        //in case if cycle founded later , also dict should be false.
        if(result.length() != graph.size()){
            return "";
        }

        return result.toString();

    }
}