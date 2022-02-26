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
    boolean valid = true;
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return valid;
    }
    
    void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        System.out.println(root.val);
        if(pre != null && pre.val >= root.val){
            System.out.println(root.val+"<<<<"+pre.val);
            valid = false;
            return;
        }
        pre = root;
        helper(root.right);
        // pre = root;
        System.out.println("pre->"+pre.val);
    }
}