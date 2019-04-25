/**
 * Created by apple on 2019/4/23.
 */
public class Solution24 {
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i=2;i<7;i++){
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode n = swapPairs(head);
        while (n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        while (pre!=null && pre.next!=null && pre.next.next!=null){
            swap(pre, pre.next, pre.next.next, pre.next.next.next);
            pre = pre.next.next;
        }
        return node.next;
    }

    public static void swap(ListNode pre, ListNode n1, ListNode n2, ListNode next){
        pre.next = n2;
        n2.next = n1;
        n1.next = next;
    }
}
