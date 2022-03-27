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
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root == null)
            return result;
        
        //Iterative
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            result.add(top.val);
            root = top.right;
        }
        
        
        return result;
        
        //Recursive
        // helper(root);
        // return result;
    }
    void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}