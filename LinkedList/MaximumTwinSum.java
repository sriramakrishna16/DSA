package LinkedList;

//problem , given linked list head so we have to return the maximum pair sum
// pairs are ith node and n-1-ith and n is length and is even number.

public class MaximumTwinSum{
    public static void main(String [] args){
        MyLinkedList list = new MyLinkedList();
        int [] arr = {5,4,2,1};
        for(int i = 0 ; i < arr.length ; i++){
            list.add(arr[i]);
        }
        int ans = pairSum(list.head);
        System.out.println(ans);
    }
    public static int pairSum(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        int maxSum = 0;
        ListNode first = head;
        ListNode second = prev;
        while(second != null){
            int sum = first.val + second.val;
            maxSum = Math.max(maxSum, sum);

            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
}