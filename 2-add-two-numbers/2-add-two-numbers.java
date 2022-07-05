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
        ListNode head = new ListNode(-1);
        ListNode result = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int v1 = l1.val;
            int v2 = l2.val;
            int sum = v1 + v2 + carry;
            int v3 = (sum) % 10;
            carry = (sum) / 10;
            ListNode n = new ListNode(v3);
            head.next = n;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int sum1 = carry + l1.val;
            carry = sum1 /10;
            ListNode n1 = new ListNode(sum1 % 10);
            head.next = n1;
            head = head.next;
            l1 = l1.next;
        }
        
         while(l2 != null){
            int sum1 = carry + l2.val;
            carry = sum1 /10;
            ListNode n2 = new ListNode(sum1 % 10);
            head.next = n2;
            head = head.next;
            l2 = l2.next;
        }
        
        if(carry != 0){
            ListNode n3 = new ListNode(1);
            head.next = n3;
        }
        
        return result.next;
        
    }
}