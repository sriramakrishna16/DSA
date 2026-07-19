package LinkedList;
import java.util.HashMap;

class Node{
        int val;
        Node next;
        Node random;
        Node(int val){
            this.val = val;
        }
        Node(int val, Node next, Node random){
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

public class CopyListWithRandomPointer {
    public static void main(String args[]){
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        printList(n1);

        Node copied = copyRandomList(n1);
        
        System.out.println("new copied list");
        printList(copied);
    }
    public static void printList(Node head){
        Node current = head;
        while(current != null){
            System.out.print("Node = " + current.val);
            if(current.random != null){
                System.out.print(", Random = " + current.random.val);
            }else{
                System.out.print(", Random = Null");
            }
            System.out.println();
            current = current.next;
        }
    }
    // public static Node copyRandomList(Node head){
    //     if(head == null) return null;
    //     HashMap<Node,Node> map = new HashMap<>();
    //     Node curr = head;
        
    //     while(curr != null){
    //         map.put(curr , new Node(curr.val));
    //         curr = curr.next;
    //     }

    //     curr = head;

    //     while(curr != null){
    //         Node copy = map.get(curr);
    //         copy.next = map.get(curr.next);
    //         copy.random = map.get(curr.random);
    //         curr = curr.next;
    //     }
    //     return map.get(head);
    // }

    //more optimised version with O(1) space
    public static Node copyRandomList(Node head){
        if(head == null) return null;
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        //7 -> 7' -> 13 -> 13' -> 11 -> 11'
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        //7 -> 7' -> 13 -> 13' -> 11 -> 11'
        curr = head;
        Node dummy = new Node(0);
        Node currCopy = dummy;
        while(curr != null){
            currCopy.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return dummy.next;
    }
}
