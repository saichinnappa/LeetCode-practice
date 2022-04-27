

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
        // helper(root);

        if(root == null)
            return false;
        // TreeNode prev = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode top = stack.pop();
            if(prev != null && prev.val >= top.val)
                return false;
            prev = top;
            
            root = top.right;
            
        }
        
        
        return isValid;
    }
    
    void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if(prev != null && prev.val >= root.val)
            isValid = false;
        prev = root;
        helper(root.right);
    }
}