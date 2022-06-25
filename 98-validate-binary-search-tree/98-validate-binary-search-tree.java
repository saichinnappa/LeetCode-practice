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
        // helper(root);
        // return isValid;
        
        if(root == null)
            return false;
        
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode top = stack.pop();
            if(prev != null){
                if(prev.val >= top.val)
                    return false;
            }
            prev = top;
            curr = top.right;
        }
        return true;
        
    }
    
    void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if(pre != null){
            if(pre.val >= root.val)
                isValid = false;
        }
        pre = root;
        helper(root.right);
    }
}