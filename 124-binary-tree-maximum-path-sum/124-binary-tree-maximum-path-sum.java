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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        dfs(root);
        return result;
    }
    
    int dfs(TreeNode root){
        if(root == null)
            return 0;
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        
        //with split
        result = Math.max(result, root.val + leftMax + rightMax);
        
        //cannot split, so only send max of right or left to the root to calculate at root level.
        
        return root.val + Math.max(leftMax, rightMax);
        
    }
    
}