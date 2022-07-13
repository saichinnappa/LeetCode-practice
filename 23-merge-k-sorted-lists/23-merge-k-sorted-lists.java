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
        
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        
        ListNode head = mergeSortedLists(lists[0], lists[1]);
        for(int i = 2; i < lists.length; i++){
            head = mergeSortedLists(head, lists[i]);
        }
        
        return head;
        // return mergeLists(lists, 0, lists.length - 1);
    }
    
//     ListNode mergeLists(ListNode[] lists, int start, int end){
//         if(start > end)
//             return null;
//         if(start == end){
//             return lists[start];
//         }
        
//         int mid = (start + end) / 2;
//         ListNode left = mergeLists(lists, start, mid);
//         ListNode right = mergeLists(lists, mid + 1, end);
//         return mergeSortedLists(left, right);
//     }
    
    private ListNode mergeSortedLists(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

        ListNode head = null;
		if (list1.val < list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}
        head.next = mergeSortedLists(list1, list2);
        return head;
	}
    
    
}