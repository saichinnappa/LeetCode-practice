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
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // helper(root);
        
        if(root == null)
            return result;
        
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        // stack.push(root);
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode top = stack.pop();
            result.add(top.val);
            root = top.right;
            
        }
        
        
        return result;
    }
    
    private void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
}