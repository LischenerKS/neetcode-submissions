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
    public boolean hasCycle(ListNode head) {
        ListNode weWasHereNode = head;


        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            if (weWasHereNode.equals(cur.next)) return true;
            next = cur.next;
            cur.next = weWasHereNode;

            cur = next;
        }
        return false;
        
    }
}
