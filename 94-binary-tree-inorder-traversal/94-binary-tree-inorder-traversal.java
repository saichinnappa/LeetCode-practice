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
    List<Integer> result = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        //APPROACH 1: RECURSIVE
        // if(root == null)
        //     return result;
        // inorderTraversal(root.left);
        // result.add(root.val);
        // inorderTraversal(root.right);
        // return result;
        
        //APPROACH 2 : ITERATIVE
        Deque<TreeNode> stack = new LinkedList();
        // TreeNode prev = null;
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
    }
}