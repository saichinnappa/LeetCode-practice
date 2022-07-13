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
        TreeNode p = new TreeNode(root.val);
        p.left = invertTree(root.right);
        p.right = invertTree(root.left);
        return p;
    }
    
    void helper(TreeNode p, TreeNode q){
        if( q == null)
            return;
        if(q.right != null)
            p.left = new TreeNode(q.right.val);
        if(q.left !=null)
            p.right = new TreeNode(q.left.val);
        helper(p.left, q.right);
        helper(p.right, q.left);
    }
}