package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(){};

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class MyLinkedList{
    ListNode head = null;
    public void add(int val){
        ListNode newNode = new ListNode(val);
        ListNode current = head;
        if(head == null){
            head = newNode;
        }else{
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printValues(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

