package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//problem , given list of single linked lists , each list is ordered in ascending 
// so we have merge all lists and create one single linked list
//minHeap is the best way , because smallest values are always stored at top.
//so we use min heap to take smallest values among all lists and add into single linked list

public class MergeKSortedList {
    public static void main(String args[]){
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        MyLinkedList list3 = new MyLinkedList();

        list1.add(1);
        list1.add(4);
        list1.add(5);

        list2.add(1);
        list2.add(3);
        list2.add(4);

        list3.add(2);
        list3.add(6);

        // List<ListNode> list = new ArrayList<>();
        // list.add(list1.head);
        // list.add(list2.head);
        // list.add(list3.head);

        ListNode [] list = {list1.head,list2.head,list3.head};

        ListNode ans = mergeAll(list);

        MyLinkedList.printValues(ans);
    }
    public static ListNode mergeAll(ListNode[] list){

        //here data type is ListNode so we have provide the comparator. bcz java doesnt know about ListNode
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);

        //adding all first nodes in minHeap
        for(ListNode node : list){
            if(node != null){
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        //attaching smallest node to the dummy
        while(!minHeap.isEmpty()){

            ListNode smallest = minHeap.poll();

            current.next = smallest;

            current = current.next;

            //if list has remaining nodes add it to the minHeap
            if(smallest.next != null){
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}
