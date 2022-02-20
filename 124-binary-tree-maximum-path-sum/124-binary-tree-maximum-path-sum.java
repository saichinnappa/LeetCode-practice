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
       
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        
        int temp = Math.max(left, right);
        int ans = left + right + root.val;
        result = Math.max(result, ans);
        return temp + root.val;
        
    }
    
}