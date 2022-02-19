/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result = null;
    boolean set = false;
        
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         helper(root, p);
        return result;
    }
    
    
    void helper(TreeNode root, TreeNode p){
        if(root == null)
            return;
        helper(root.left, p);
        if(set){ result = root; set = false;}
        if(root.val == p.val){
            set = true;
        }
        helper(root.right, p);
    }
}