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
        // if(root == null)
        //     return result;
        // helper(root);
        // return result;
        
        if(root == null)
            return result;
        Deque<TreeNode> stack = new LinkedList<>();
       
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            
            TreeNode top = stack.pop();
            result.add(top.val);
            if(top.right != null)
                curr = top.right;
            
        }
            
            
        return result;
        
        
    }
    
    // void helper(TreeNode root){
    //     if(root == null)
    //         return;
    //     helper(root.left);
    //     result.add(root.val);
    //     helper(root.right);
    // }
}