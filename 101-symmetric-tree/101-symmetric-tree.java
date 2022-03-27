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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    boolean helper(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        else if(t1 == null && t2 != null)
            return false;
        else if(t1 != null && t2 == null)
            return false;
        else if(t1.val != t2.val)
            return false;
        else
            return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}