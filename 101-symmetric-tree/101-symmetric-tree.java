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
    public boolean isSymmetric(TreeNode root) {
        //recursive
        //return helper(root.left, root.right);
        //iterative
        if(root == null)
            return true;
        if((root.left != null && root.right == null) || (root.left == null && root.right != null))
            return false;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) continue;
            if((t1 == null && t2 != null) || (t1 != null && t2 == null)) return false;
            if(t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        
        }
        
        return true;
    }
    
    boolean helper(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        else if(t1 == null && t2 != null)
            return false;
        else if(t1 != null && t2 == null)
            return false;
        else if(t1.val != t2.val)
            return false;
        else
            return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}