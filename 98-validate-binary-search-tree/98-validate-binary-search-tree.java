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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;
    }
    
    void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if(prev == null)
            prev = root;
        else{
            if(prev.val >= root.val)
                isValid = false;
            prev = root;
        }
        helper(root.right);
    }
}