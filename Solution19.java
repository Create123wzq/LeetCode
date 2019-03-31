/**
 * Created by apple on 2019/3/31.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode new_node = new ListNode(0);
        new_node.next = head;
        ListNode first = new_node;
        ListNode second = new_node;
        for(int i=0;i<n+1;i++){
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return new_node.next;
    }
}


