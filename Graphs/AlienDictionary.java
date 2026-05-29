import java.util.*;

public class AlienDictionary {

    public static String alienOrder(String[] words) {

        // Graph: Character -> Neighbors
        Map<Character, Set<Character>> graph = new HashMap<>();

        // Indegree: Character -> Incoming edges count
        Map<Character, Integer> indegree = new HashMap<>();


        // Step 1: Initialize graph and indegree
        for (String word : words) {

            for (char ch : word.toCharArray()) {

                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }


        // Step 2: Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            // Invalid case
            if (word1.length() > word2.length()
                    && word1.startsWith(word2)) {

                return "";
            }

            int minLength = Math.min(
                    word1.length(),
                    word2.length()
            );

            for (int j = 0; j < minLength; j++) {

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                // First different character
                if (c1 != c2) {

                    // Avoid duplicate edges
                    if (!graph.get(c1).contains(c2)) {

                        graph.get(c1).add(c2);

                        indegree.put(
                                c2,
                                indegree.get(c2) + 1
                        );
                    }

                    // Only first difference matters
                    break;
                }
            }
        }


        // Step 3: Topological Sort (Kahn's Algorithm)

        Queue<Character> queue = new LinkedList<>();

        // Add all characters with indegree 0
        for (char ch : indegree.keySet()) {

            if (indegree.get(ch) == 0) {

                queue.offer(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            char current = queue.poll();

            result.append(current);

            for (char neighbor : graph.get(current)) {

                indegree.put(
                        neighbor,
                        indegree.get(neighbor) - 1
                );

                if (indegree.get(neighbor) == 0) {

                    queue.offer(neighbor);
                }
            }
        }


        // Step 4: Cycle detection
        if (result.length() != indegree.size()) {

            return "";
        }

        return result.toString();
    }


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
}