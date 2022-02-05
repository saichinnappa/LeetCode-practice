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
    
    TreeNode prev  = null;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        
//         // Approach 1: Iterative
//         TreeNode prev = null;
//         Deque<TreeNode> stack = new ArrayDeque();
//         while(!stack.isEmpty() || root != null){
//             while(root != null){
//                 stack.push(root);
//                 root = root.left;
//             }

//             TreeNode top = stack.pop();
//             if(prev != null && prev.val >= top.val){
//                 return false;
//             }

//             prev = top;
//             root = top.right;   
//         }
//         return true;
        
        // Approach 2: Recursive
        recursive(root);
        return isValid;
    }
    
    void recursive(TreeNode root){
        if(root == null)
            return;
        recursive(root.left);
        if(prev != null && prev.val >= root.val){
            isValid = false;
            return;
        }
        prev = root;
        recursive(root.right);
    }
}