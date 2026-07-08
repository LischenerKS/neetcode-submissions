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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        

        ListNode head = new ListNode(0); //startNode, not used
        ListNode cur;
        ListNode last = head;

        int sum;
        int carry = 0;
        int l1Val, l2Val;
        while (l1 != null || l2 != null) {
            l1Val = l1 == null ? 0 : l1.val;
            l2Val = l2 == null ? 0 : l2.val;

            sum = l1Val + l2Val + carry;
            carry = sum / 10;

            cur = new ListNode(sum % 10);

            last.next = cur;
            last = cur;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry != 0) {
            last.next = new ListNode(carry);
        }
        return head.next;
        
    }

    
}
