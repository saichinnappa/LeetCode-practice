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
    boolean isValid = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(0, targetSum, root);
        return isValid;
    }
    
    void helper(int sum, int targetSum, TreeNode root){
        if(root == null)
            return;
       
        sum += root.val;
        if(sum == targetSum && (root.left == null && root.right == null)){
            isValid = true;
            return;
        }
        helper(sum, targetSum, root.left);
        helper(sum, targetSum, root.right);
    }
}