/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isValid = true;
    public boolean isSymmetric(TreeNode root) {
//         if(root == null)
//             return true;
//         if(root.left == null && root.right != null)
//             return false;
//         if(root.left != null && root.right == null)
//             return false;
//         Deque<TreeNode> queue  = new LinkedList<TreeNode>();
//         queue.offer(root.left);
//         queue.offer(root.right);
//         while(!queue.isEmpty()){
//             TreeNode t1 = queue.poll();
//             TreeNode t2 = queue.poll();
//             if(t1 == null && t2 == null)
//                 continue;
//             if((t1 == null && t2 != null) || (t1 != null && t2 == null))
//                 return false;
//             if(t1.val != t2.val)
//                 return false;

//             queue.offer(t1.left);
//             queue.offer(t2.right);
//             queue.offer(t1.right);
//             queue.offer(t2.left);
//         }
        
//         return true;
        return helper(root.left, root.right);
        
    }
    boolean helper(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null)
            return true;
        if(r1 == null && r2 != null)
            return false;
        if(r1 != null && r2 == null)
            return false;
        if(r1.val == r2.val)
            return helper(r1.left, r2.right) && helper(r1.right, r2.left);
        return false;
            
    }
}