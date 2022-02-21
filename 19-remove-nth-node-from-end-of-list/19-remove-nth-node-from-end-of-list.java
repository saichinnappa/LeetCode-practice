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
        int totalNodes = 0;
        if(head == null)
            return head;
        ListNode curr = head;
        
        while(curr != null){
            curr = curr.next;
            totalNodes++;
        }
        
        int count = totalNodes - n;
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        
        
        while(count != 0){
            prev.next = head;
            prev = head;
            head = head.next;
            count--;
        }
        
        prev.next = head.next;
        return result.next;
    }
}