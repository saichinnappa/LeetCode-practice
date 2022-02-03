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
        
        // APPROACH 1
        // First count all the nodes and then remove (total - n + 1)
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
//         ListNode first = head;
//         int count = 0;
        
//         while(first != null){
//             count++;
//             first = first.next;
//         }
        
//         first = dummy;
//         count = count - n;
        
//         while(count > 0){
//             count--;
//             first = first.next;
//         }
        
//         first.next = first.next.next;
        
//         return dummy.next;
        
        // APPROACH 2
        //Two pointers
        // slow keep running at one node at a time, whereas fast runs n times so that slow and fast are n distance apart at any given time.
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}