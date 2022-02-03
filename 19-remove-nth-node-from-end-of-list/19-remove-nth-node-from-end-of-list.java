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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        int count = 0;
        
        while(first != null){
            count++;
            first = first.next;
        }
        
        first = dummy;
        count = count - n;
        
        while(count > 0){
            count--;
            first = first.next;
        }
        
        first.next = first.next.next;
        
        return dummy.next;
        
    }
}