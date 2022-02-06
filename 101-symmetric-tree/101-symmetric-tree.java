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
        
        
        // APPROACH 1: 
        // Step 1: Do preorder and postorder
        // Step 2: reverse postorder and compare with preorder
        // preorder(root);
        // postorder(root);
        // Collections.reverse(postList);
        // return preList.equals(postList);
        
        // APPROACH 2:
        // Step 1: Start from immediate left and right from the root.
        // Step 2: Compare left.left with right.right, and left.right with right.left.
        
        return helper(root.left, root.right);
        
    }
    
    
    boolean helper(TreeNode left, TreeNode right){
        
        //If both left and right are null, it may be a leaf node, so return true;
        if(left == null && right == null)
            return true;
        //One side of a tree cannot be null, fails symmetric condition
        if(left == null || right == null)
            return false;
        
        if(left.val == right.val){
            return helper(left.left, right.right) && helper(left.right, right.left);
        } else{
            return false;
        }
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
