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
//         int totalNodes = 0;
//         ListNode curr = head;
//         while(curr != null){
//             curr = curr.next;
//             totalNodes++;
//         }
//         ListNode prev = new ListNode(-1);
//         ListNode result = prev;
//         int a = totalNodes - n;
        
//         while(a != 0){
//             prev.next = head;
//             head = head.next;
//             prev = prev.next;
//             a--;
//         }
//         prev.next = head.next;
//         return result.next;
        
        
        ListNode slow = new ListNode(-1);
        ListNode fast = new ListNode(-1);
        ListNode result = slow;
        slow.next = head;
        fast.next = head;
        
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return result.next;
        
        
    }
}