package LinkedList;

public class MergeTwoSortedList {
    public static void main(String args[]){
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();

        list1.add(1);
        list1.add(2);
        list1.add(4);

        list2.add(1);
        list2.add(3);
        list2.add(4);

        list1.printValues();
        System.out.println();
        list2.printValues();
        System.out.println();

        ListNode ans = mergeLists(list1.head, list2.head);
        MyLinkedList.printValues(ans);

    }

    public static ListNode mergeLists(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(head1 != null && head2 != null ){
            if(head1.val <= head2.val){
                curr.next = head1;
                head1 = head1.next;
            }else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if(head1 != null) curr.next = head1;
        if(head2 != null) curr.next = head2;
        return dummy.next;

    }
}
