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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode firstListCurNode = list1;
        ListNode secondListCurNode = list2;

        ListNode head = null;


        if (firstListCurNode == null && secondListCurNode == null) return null;
        else if (secondListCurNode == null) {
            head = firstListCurNode;
            firstListCurNode = firstListCurNode.next;
        }
        else if (firstListCurNode == null) {
            head = secondListCurNode;
            secondListCurNode = secondListCurNode.next;
        }
        else if (firstListCurNode.val <= secondListCurNode.val) {
            head = firstListCurNode;
            firstListCurNode = firstListCurNode.next;
        }
        else {
            head = secondListCurNode;
            secondListCurNode = secondListCurNode.next;
        }

        ListNode last = head;
        ListNode cur;
        while (firstListCurNode != null && secondListCurNode != null) {
            if (firstListCurNode.val <= secondListCurNode.val) {
                cur = firstListCurNode;
                firstListCurNode = firstListCurNode.next;
            }
            else {
                cur = secondListCurNode;
                secondListCurNode = secondListCurNode.next;
            }
            last.next = cur;

            last = cur;
        }

        if (firstListCurNode != null) {
            last.next = firstListCurNode;
        }
        else {
            last.next = secondListCurNode;

        }

        return head;

    }
}