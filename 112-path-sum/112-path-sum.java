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
        
        return helper(root, targetSum, 0);
        
        
    }
    
    boolean helper(TreeNode root, int targetSum, int currentSum){
        if(root == null){
            return false;
        }
        currentSum += root.val;
       
        if(root.left == null && root.right == null){
             if(currentSum == targetSum){
                return true;
             } else
                currentSum -= root.val;
        }
        
        return helper(root.left, targetSum, currentSum) || helper(root.right, targetSum, currentSum);
        
    }
}