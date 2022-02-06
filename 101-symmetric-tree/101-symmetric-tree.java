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
    List<Integer> preList = new ArrayList<>();
    List<Integer> postList = new ArrayList<>();
    
    public boolean isSymmetric(TreeNode root) {
        TreeNode preRoot = root;
        TreeNode postRoot = root;
        preorder(root);
        postorder(root);
        
       Collections.reverse(postList);
        
        return preList.equals(postList);
        
    }
    
    
    void preorder(TreeNode root){
        if(root == null){
            preList.add(null);
            return;
        }
        preList.add(root.val);
        preorder(root.left);
        preorder(root.right);
            
    }
    
    
    void postorder(TreeNode root){
        if(root == null){
            postList.add(null);
            return;
        }
        postorder(root.left);
        postorder(root.right);
        postList.add(root.val);
    }
    
}