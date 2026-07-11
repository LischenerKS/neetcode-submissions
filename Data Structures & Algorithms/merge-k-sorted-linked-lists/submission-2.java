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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode head = new ListNode(0); //before real head
        selectLessNodeAndConnect(head, lists);
        return head.next;
    }
    
    public void selectLessNodeAndConnect(ListNode last, ListNode[] lists) {
        boolean isAllNull = true;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                isAllNull = false;
                break;
            }
        }
        if (isAllNull) return;

        int minNodeIndex = -1;
        int minNodeVal = Integer.MAX_VALUE;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            else if (lists[i].val < minNodeVal) {
                minNodeIndex = i;
                minNodeVal = lists[i].val;
            }
        }

        last.next = new ListNode(minNodeVal);
        lists[minNodeIndex] = lists[minNodeIndex].next;
        selectLessNodeAndConnect(last.next, lists);

    }

}
