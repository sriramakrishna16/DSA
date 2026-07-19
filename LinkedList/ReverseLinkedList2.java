package LinkedList;

public class ReverseLinkedList2 {
    public static void main(String args[]){
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printValues();
        int first = 2;
        int last = 4; 
        ListNode ans = reverseList(list.head,first, last);
        list.printValues(ans);
    }
    public static ListNode reverseList(ListNode head, int left, int right){
        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for(int i = 1; i < left ; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode next = null;
        ListNode prevNode = null;

        for(int i = left ; i <= right ; i++){
            next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;
        }

        prev.next.next = curr;
        prev.next = prevNode;

        return dummy.next;
    }
}
