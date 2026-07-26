package LinkedList;

//sub-category : Divide and Conquer

public class SortList {
    public static void main(String args[]){
        MyLinkedList list = new MyLinkedList();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
        ListNode ans = sort(list.head);
        list.printValues(ans);
    }
    public static ListNode sort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode left = sort(head);
        ListNode right = sort(second);

        return merge(left, right);
    }
    private static ListNode merge(ListNode left , ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(left != null && right != null){
            if(left.val <= right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if(left != null){
            curr.next = left;
        }else{
            curr.next = right;
        }

        return dummy.next;
    }
}
