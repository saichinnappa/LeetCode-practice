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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        
//         ListNode head = mergeTwoLists(lists[0], lists[1]);
        
//         for(int i = 2; i < lists.length; i++){
//             head = mergeTwoLists(head, lists[i]);
//         }
        
//         return head;
        
        
        int interval = 1;
        int length = lists.length;
        while(interval < length){
            for(int i = 0; i < length - interval; i += (interval * 2)){
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            
            interval *= 2;
        }
        
        return lists[0];
        
    }
    
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2.val < l1.val){
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            } else{
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
                temp = temp.next;
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 == null) ? l2 : l1;
        
        return head.next;
    }
}