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
        //APPROACH 1: MERGE ONE BY ONE, AFTER FIRST TWO ARE MERGED
//         if(lists.length == 0)
//             return null;
//         if(lists.length == 1)
//             return lists[0];
        
//         ListNode head = mergeLists(lists[0], lists[1]);
//         for(int i = 2; i < lists.length; i++){
//             head = mergeLists(head, lists[i]);
//         }
        
//         return head;
        
        //APPROACH 2: Merge Sort
        int interval = 1;
        int length = lists.length;
        while(interval < length){
            for(int i = 0; i < length - interval; i += interval * 2){
                lists[i] = mergeLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        
        return lists.length > 0 ? lists[0] : null;
      
    }
    
    
    ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2.val < l1.val){
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            } else{
                head.next = new ListNode(l1.val);
                head = head.next;
                l1 = l1.next;
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

    
}