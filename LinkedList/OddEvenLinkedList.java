package LinkedList;

public class OddEvenLinkedList{
    public static void main(String [] args){
        MyLinkedList list = new MyLinkedList();
        int [] arr = {1,2,3,4,5};
        for(int num : arr){
            list.add(num);
        }
        ListNode head = oddEvenList(list.head);
        list.printValues(head);
    }
    public static ListNode oddEvenList(ListNode head){
        //normal run

        // if (head == null || head.next == null || head.next.next == null){
        //     return head;
        // }
        // ListNode odd = head;
        // ListNode even = head.next;
        // head = head.next.next;
        // ListNode dummy1 = odd;
        // ListNode dummy2 = even;
        // int count = 3;
        // while(head != null){
        //     if(count % 2 == 1){
        //         odd.next = head;
        //         odd = odd.next;
        //     }else{
        //         even.next = head;
        //         even = even.next;
        //     }
        //     head = head.next;
        //     count++;
        // }
        // even.next = null;
        // odd.next = dummy2;
        // return dummy1;

        //space optimised approach

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;            
        }
        odd.next = evenHead;
        return head;
    }
}