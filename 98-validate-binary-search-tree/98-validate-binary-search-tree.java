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
    TreeNode pre = null;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValid;
    }
    
    void helper(TreeNode root){
        if(root == null)
            return;
        isValidBST(root.left);
        if(pre != null && pre.val >= root.val){
            isValid = false;
            return;
        }
        pre = root;
        isValidBST(root.right);
    }
}