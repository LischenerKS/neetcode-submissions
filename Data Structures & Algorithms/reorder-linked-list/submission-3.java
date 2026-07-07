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
    public void reorderList(ListNode head) {
        if (head.next == null) return;

        ListNode reverseHead;
        ListNode cur = new ListNode(head.val, head.next);
        ListNode last = null;
        ListNode next;

        while(cur.next != null) {
            next = cur.next;

            cur.next = last;
            last = cur;
            cur = new ListNode(next.val, next.next);
        }
        reverseHead = cur;
        reverseHead.next = last;
        

 
        
        ListNode standartHead = new ListNode(head.val, head.next);
        cur = standartHead;
        int length = 0;

        while (cur != null) {
            next = cur.next == null ? null : new ListNode(cur.next.val, cur.next.next);
            cur.next = next;
            cur = next;
            length++;
        }
        

        cur = head;
        for (int i = 0; i < length; i++) {


            if (i%2 == 0) {
                cur.next = new ListNode(reverseHead.val, reverseHead.next);
                if (reverseHead.next != null) reverseHead = reverseHead.next;
            }
            else {
                if (standartHead.next != null) standartHead = standartHead.next;
                cur.next = new ListNode(standartHead.val, standartHead.next);
            }


            if (i != length - 1) cur =  cur.next;
            
        }
        cur.next = null;

    }
}
