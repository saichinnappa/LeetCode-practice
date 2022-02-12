// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Set<ListNode> set = new HashSet();
//         // ListNode result = null;
//         while(headA != null){
//             set.add(headA);
//             headA = headA.next;
//         }
        
//         while(headB != null){
//             if(set.contains(headB))
//                 return headB;
//             headB = headB.next;
//         }
        
//         return null;
//     }
// }

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pB;
        // Note: In the case lists do not intersect, the pointers for A and B
        // will still line up in the 2nd iteration, just that here won't be
        // a common node down the list and both will reach their respective ends
        // at the same time. So pA will be NULL in that case.
    }
}