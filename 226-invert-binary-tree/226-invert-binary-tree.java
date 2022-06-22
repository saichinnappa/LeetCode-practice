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
    public TreeNode invertTree(TreeNode root) {
        
        // recursive
        // if(root == null)
        //     return root;
        // TreeNode left = invertTree(root.left);
        // TreeNode right = invertTree(root.right);
        // root.left = right;
        // root.right = left;
        // return root;
        
        // iterative
        if(root == null)
            return root;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left != null)
                queue.offer(current.left);
            if(current.right != null)
                queue.offer(current.right);
        }
        return root;
    }
}