package LinkedList;

public class RotateList{
    public static void main(String args[]){
        MyLinkedList list = new MyLinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        // list.add(4);
        // list.add(5);
        list.printValues();
        int k = 4;
        ListNode ans = rotate(list.head,k);
        System.out.println();
        list.printValues(ans);
    }
    // 1 2 3 4 5
    public static ListNode rotate(ListNode head, int k){
        if (head == null || head.next == null || k == 0) return head;

        int len = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        k %= len;
        if(k % len == 0) return head;

        tail.next = head;
        
        ListNode curr = head;

        for(int i = 0 ; i < len - k - 1 ; i++){
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}