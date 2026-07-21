package Trees;
import java.util.*;

public class PopulatingNextRightPointersInEachNode {
    static class Node{
        int val;
        Node left;
        Node right;
        Node next;
        Node(){}
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String args[]){        
        Integer arr[] = {1,2,3,4,5,6,7};
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        Node node = connect(root);

        printLevels(node);
    }
    public static void printLevels(Node root){
        Node leftMost = root;
        while(leftMost != null){
            Node curr = leftMost;
            while(curr != null){
                System.out.print(curr.val+" -> ");
                curr = curr.next;
            }
            System.out.print("null");
            System.out.println();
            leftMost = leftMost.left;
        }
    }
    // public static Node connect(Node root){
    //     if(root == null) return null;
    //     Queue<Node> q = new LinkedList<>();
    //     q.offer(root);
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         Node prev = null;
    //         for(int i = 0 ; i < size ; i++){
    //             Node curr = q.poll();
    //             if(prev != null){
    //                 prev.next = curr;
    //             }
    //             prev = curr;
    //             if(curr.left != null){
    //                 q.offer(curr.left);
    //             }
    //             if(curr.right != null){
    //                 q.offer(curr.right);
    //             }
    //         }
    //     }
    //     return root;
    // }

    // space optimised version
    public static Node connect(Node root){
        if(root == null) return null;
        Node leftMost = root;
        while(leftMost.left != null){
            Node curr = leftMost;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
