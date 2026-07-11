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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        
        ListNode iter = head;
        while (iter != null) {
            size++;
            iter = iter.next;
        }

        ListNode ans = new ListNode(0); //ans = ans.next

        ListNode tailOfPrevGroup = ans; //указывает на последнюю ноду прошлой группы, пересчет после реверса

        ListNode headOfNextGroup;
        ListNode headOfThisGroup = head; 
        ListNode tailOfThisGroup = head; // считается от головы текущей группы
        int cnt = 0;

        while (cnt + k <= size) {
            tailOfThisGroup = headOfThisGroup;
            for (int i = 1; i < k; i++) { //шагов на 1 меньше чем нод
                tailOfThisGroup = tailOfThisGroup.next;
            }
            headOfNextGroup = tailOfThisGroup.next;

            reverseOneGroup(headOfThisGroup, k);


            //swap
            ListNode temp = headOfThisGroup;
            headOfThisGroup = tailOfThisGroup;
            tailOfThisGroup = temp;


            tailOfPrevGroup.next = headOfThisGroup;
            tailOfThisGroup.next = headOfNextGroup;


            
            cnt += k;
            tailOfPrevGroup = tailOfThisGroup;
            headOfThisGroup = tailOfThisGroup.next;
            // return headOfThisGroup;
        }


        return ans.next;
    }

    public void reverseOneGroup(ListNode headOfGroup, int k) {
        Stack<ListNode> stack = new Stack<>();

        ListNode i = headOfGroup;
        for (int j = 0; j < k; j++) {
            stack.push(i);
            i = i.next;
        }


        ListNode last = stack.pop();
        while (!stack.empty()) {
            i = stack.pop();
            last.next = i;
            last = i;
        }
        last.next = null;
    }



}
