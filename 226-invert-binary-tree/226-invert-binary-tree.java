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
        TreeNode result = new TreeNode(root.val);
        helper(result, root);
        return result;
    }
    
    void helper(TreeNode r1, TreeNode r2){
        if(r1 == null || r2 == null)
            return;
        if(r2.left != null)
            r1.right = new TreeNode(r2.left.val);
        if(r2.right != null)
            r1.left = new TreeNode(r2.right.val);
        helper(r1.left, r2.right);
        helper(r1.right, r2.left);
    }
}