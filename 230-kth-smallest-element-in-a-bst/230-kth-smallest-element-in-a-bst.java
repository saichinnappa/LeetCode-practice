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
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int result;
    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        while(k != 0){
            result = queue.poll();
            k--;
        }
        return result;
    }
    
    void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        queue.offer(root.val);
        helper(root.right);
    }
}