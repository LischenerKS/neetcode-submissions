/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }

        if (head.next == null) return null;

        cur = head;
        ListNode last = null;

        
        for (int i = 0; i <= size - n; i++) {
            if (i < size - n) {
                last = cur;
                cur = cur.next;
            }
            else {
                if (i == 0) return head.next;
                last.next = cur.next;
                return head;
            }
        } 
        return new ListNode(123456);

    }
}
