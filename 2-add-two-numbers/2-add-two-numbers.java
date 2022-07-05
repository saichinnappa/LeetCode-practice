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
        
//         while(l1 != null){
//             int sum1 = carry + l1.val;
//             carry = sum1 /10;
//             ListNode n1 = new ListNode(sum1 % 10);
//             head.next = n1;
//             head = head.next;
//             l1 = l1.next;
//         }
        
//          while(l2 != null){
//             int sum1 = carry + l2.val;
//             carry = sum1 /10;
//             ListNode n2 = new ListNode(sum1 % 10);
//             head.next = n2;
//             head = head.next;
//             l2 = l2.next;
//         }
        
        if(carry != 0){
            ListNode n3 = new ListNode(1);
            head.next = n3;
        }
        
        return result.next;
        
    }
}