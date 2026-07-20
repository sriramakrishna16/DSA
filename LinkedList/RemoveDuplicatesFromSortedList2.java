package LinkedList;

public class RemoveDuplicatesFromSortedList2 {
    public static void main(String args[]){
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printValues();

        ListNode ans = removeDuplicates(list.head);
        list.printValues(ans);
    }
    public static ListNode removeDuplicates(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;
        // 1 1 1 2 3 4 5
        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
