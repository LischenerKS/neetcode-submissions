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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode lastNode = head;
        ListNode curNode = head.next;

        ListNode newHead = new ListNode(head.val);
        while (curNode != null) {
            newHead = new ListNode(curNode.val, newHead);

            lastNode = curNode;
            curNode = curNode.next; 
        }
        return newHead;
    }
}
