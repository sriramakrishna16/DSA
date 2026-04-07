package LinkedList;

public class RemoveNthNodeFromEnd {
    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next  = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        ListNode ans = removeNthNode(node1, 2);
        MyLinkedList.printValues(ans);
    }
   
    public static ListNode removeNthNode(ListNode head, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 0; i < n ; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
