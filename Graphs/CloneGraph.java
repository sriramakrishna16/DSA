package Graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Node{
    public int val;
    public List<Node> neighbors;
    public Node(){
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val){
        this.val = val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
public class CloneGraph {
    public static void main(String args[]){

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node finalGraph = cloneGraph(node1);

        System.out.println("cloned - graph");
        printGraph(finalGraph, new HashSet<>()); //cloned graph
        System.out.println("original - graph");
        printGraph(node1 , new HashSet<>()); //original graph
    }
    public static void printGraph(Node node, HashSet<Integer> visited){
        if(node == null || visited.contains(node.val)){
            return;
        }

        visited.add(node.val);

        System.out.print("Node" + " " + node.val + " " + "->" + " ");

        for(Node neighbor : node.neighbors){
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for(Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

    static HashMap<Node, Node> map = new HashMap<>();

    public static Node cloneGraph(Node node1){

        if(node1 == null){
            return null;
        }

        if(map.containsKey(node1)){
            return map.get(node1);
        }

        Node copy = new Node(node1.val);

        map.put(node1,copy);

        for(Node neighbor : node1.neighbors){
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
    
}
