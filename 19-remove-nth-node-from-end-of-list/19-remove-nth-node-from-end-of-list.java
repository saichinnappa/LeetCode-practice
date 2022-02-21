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
//         if(head == null)
//             return head;
//         ListNode curr = head;
        
//         while(curr != null){
//             curr = curr.next;
//             totalNodes++;
//         }
        
//         int count = totalNodes - n;
//         ListNode prev = new ListNode(-1);
//         ListNode result = prev;
        
        
//         while(count != 0){
//             prev.next = head;
//             prev = head;
//             head = head.next;
//             count--;
//         }
        
//         prev.next = head.next;
//         return result.next;
        
        if(head == null)
            return head;
        
        ListNode fast = new ListNode(-1);
        ListNode slow = new ListNode(-1);
        fast.next = head;
        slow.next = head;
        ListNode dummy = slow;
        for(int i = 0; i< n; i++){
            fast = fast.next;
        }
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}