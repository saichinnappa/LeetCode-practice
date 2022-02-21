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
        
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        ListNode curr = head;
        if(head == null)
            return head;
        int totalNodes = 0;
        while(head != null){
            totalNodes++;
            head = head.next;
        }
   
        int count = totalNodes - n;
        
        while(count != 0){
            prev.next = curr;
            prev = curr;
            curr = curr.next;
            count--;
        }
        System.out.println(prev.val+" ");
        prev.next = curr.next;
        
        return result.next;
    }
}