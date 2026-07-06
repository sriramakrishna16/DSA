package PriorityQueue;
import java.util.PriorityQueue;
import LinkedList.ListNode;

//problem , given list of head nodes that represents linkedlists which are in ascending order
// so that , we have to merge all linked list and form a single list and return the head.

//simple and best solution is min heap 
// we store every node in minHeap that polls min value first and we add every min value to new dummy list

public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        ListNode list1 = createList(new int[]{1, 4, 5});
        ListNode list2 = createList(new int[]{1, 3, 4});
        ListNode list3 = createList(new int[]{2, 6});

        ListNode[] lists = {list1, list2, list3};

        System.out.println("input lists:");

        printList(list1);
        printList(list2);
        printList(list3);

        ListNode ans = mergeKLists(lists);

        printList(ans);
    }
    public static ListNode createList(int[] arr) {

        if (arr.length == 0){
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null){
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            ListNode curr = pq.poll();

            tail.next = curr;
            tail = tail.next;

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
