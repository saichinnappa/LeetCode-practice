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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        helper(p , q);
        return isValid;
    }
    
    void helper(TreeNode p, TreeNode q){
        
        if((p == null && q != null) || (p != null && q == null) || ((p != null && q != null) && (p.val != q.val))){
            isValid = false;
        }
        if(p != null && q != null){
            helper(p.left, q.left);
            helper(p.right, q.right);    
        }    
        
    }
}