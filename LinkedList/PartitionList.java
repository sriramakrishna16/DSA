package LinkedList;

//Leetcode 86 -> partiton list
// problem , by using give k valen , we have to partion such that less tha k appear before the values 
// greater than or equal to k

public class PartitionList {
    public static void main(String args[]){
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(2);
        list.printValues();
        int k = 3;
        ListNode ans = partition(list.head, k);
        list.printValues(ans);
    }
    // 1 4 3 2 5 2
    public static ListNode partition(ListNode head, int k){
        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);

        ListNode before = beforeDummy;
        ListNode after = afterDummy;

        ListNode curr = head;
        while(curr != null){
            if(curr.val < k){
                before.next = curr;
                before = before.next;
            }else{
                after.next = curr;
                after = after.next;
            }
            curr = curr.next;
        }
        after.next = null;
        before.next = afterDummy.next;
        return beforeDummy.next;
    }
}
