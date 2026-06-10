package LinkedList;

//problem , given single linked list of nodes , that is L0 -> L1 .....-> Ln-1 -> Ln 
//so we have to reorder this list in the format of L0 -> Ln -> L1 -> Ln-1 ->.....

//we can clearly observe that , last part of list is added to first part in reverse Ln->Ln-1->Ln-2
//So , we can find solution by dividing the list into two halves and reverse the second half

//now we can connect one by one from first half and reversed secondhalf.

public class ReorderList {
    public static void main(String args[]){
        //i have created my own linkedlist and add method
        MyLinkedList list = new MyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        //these are my own methods to print values 
        list.printValues();
        System.out.println();
        reorderList(list.head);
        list.printValues();
        
    }
    public static void reorderList(ListNode head){
       if(head == null || head.next == null){
        return;
       }

       ListNode slow = head;
       ListNode fast = head;

       //using slow fast method to divide the list into two halves.
       while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
       }

       ListNode secondPart = slow.next;

       //break into two parts 
       slow.next = null;

       ListNode attach = null;

       //reversing the second half
       while(secondPart != null){
        ListNode Next = secondPart.next;
        secondPart.next = attach;
        attach = secondPart;
        secondPart = Next;
       }

       ListNode first = head;
       ListNode second = attach;

       //adding both first and second halves
       while(second != null){
        ListNode temp1 = first.next;
        ListNode temp2 = second.next;

        first.next = second;
        second.next = temp1;

        first = temp1;
        second = temp2;

       }
    }
}
