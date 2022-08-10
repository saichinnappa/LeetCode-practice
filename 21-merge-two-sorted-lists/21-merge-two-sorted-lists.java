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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)   
            return list2;
        else if(list2 == null)
            return list1;
        
        ListNode result = null;
        if(list1.val < list2.val){
            result = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            result = new ListNode(list2.val);
            list2 = list2.next;
        }
        result.next = mergeTwoLists(list1, list2);
        return result;
    }
}