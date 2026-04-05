package LinkedList;

public class ReverseLinkedList {
    public static void main(String [] args){
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printValues();   
        System.out.println();
        
        ListNode ans = reverseList(list.head);
        list.head = ans;
        list.printValues();


    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

