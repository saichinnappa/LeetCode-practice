/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        Set<ListNode> set = new HashSet<>();
        
        while(head != null){
            if(!set.contains(head))
                set.add(head);
            else
                return true;
            head = head.next;
        }
        return false;
    }
}