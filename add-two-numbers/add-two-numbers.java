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
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(sum > 9){
                int mod = sum % 10;
                carry = 1;
                dummy.next = new ListNode(mod);
            } else{
                dummy.next = new ListNode(sum);
                carry = 0;
            }
            dummy = dummy.next;
        }
        if(carry != 0)
            dummy.next = new ListNode(carry);
        return result.next;
    }
}