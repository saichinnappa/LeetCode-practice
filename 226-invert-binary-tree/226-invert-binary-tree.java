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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode r1 = new TreeNode(root.val);
        helper(root, r1);
        return r1;
    }
    
    void helper(TreeNode r, TreeNode r1){
        if( r == null || r1 == null )
            return;
        if(r.right != null)
            r1.left = new TreeNode(r.right.val);
        if(r.left != null)
            r1.right = new TreeNode(r.left.val);
        helper(r.left, r1.right);
        helper(r.right, r1.left);
    }
}