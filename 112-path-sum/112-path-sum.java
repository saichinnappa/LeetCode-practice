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
    int sum = 0;
    boolean valid = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return false;
        
        helper(root, targetSum, 0);
        
        return valid;
        
        
        
    }
    
    void helper(TreeNode root, int targetSum, int currentSum){
        if(root == null){
            return;
        }
        currentSum += root.val;
       
        if(root.left == null && root.right == null){
             if(currentSum == targetSum){
                valid = true;
                return;
             } else
                currentSum -= root.val;
        }
        
        helper(root.left, targetSum, currentSum);
        helper(root.right, targetSum, currentSum);
    }
}