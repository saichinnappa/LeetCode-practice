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
    public boolean isValidBST(TreeNode root) {
        
        //Iterative
        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode prev = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
                    
            }
            
            TreeNode top = stack.pop();
            
            if(prev != null && prev.val >= top.val){
                return false;
            }
            
            prev = top;
            root = top.right;
            
        }
        
        return true;
    }
}