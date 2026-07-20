package LinkedList;

public class ReverseNodesInKGroups {
    public static void main(String args[]){
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printValues();
        int k = 2;
        ListNode ans = reverse(list.head,k);
        list.printValues(ans);
    }
    public static ListNode reverse(ListNode head , int k){
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 1 2 3 4 5
        ListNode prevGroup = dummy;
        while(true){
            ListNode kth = prevGroup;
            for(int i = 0; i<k ; i++){
                kth = kth.next;
            }

            if(kth == null) break;

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode curr = prevGroup.next;

            while(curr != groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
        return dummy.next;
    }
}
