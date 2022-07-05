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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(-1);
        ListNode result = head;
        int carry = 0;

        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            int val = (sum) % 10;
            carry = (sum) / 10;
            ListNode n = new ListNode(val);
            head.next = n;
            head = head.next;
            
        }
        
        if(carry != 0){
            ListNode n3 = new ListNode(1);
            head.next = n3;
        }
        
        return result.next;
        
    }
}