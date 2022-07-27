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
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;
        //Get to the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the list from the middle
        ListNode mid = slow;
        ListNode prev = null;
        while(mid != null){
            ListNode temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
        }
        
        //Compare first half with last half of the elements
        ListNode curr = head;
        // ListNode curr1 = prev;
        while(prev != null){
            if(curr.val != prev.val)
                return false;
            curr = curr.next;
            prev = prev.next;
        }
        
        return true;
    }
}