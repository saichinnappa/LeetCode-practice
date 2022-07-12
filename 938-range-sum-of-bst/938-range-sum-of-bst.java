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
    int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        //APPROACH 1: Recursive
        // First check the root value with low and hight
        // case 1: if it falls in between, the start traversing from the root.
        // case 2: if high <= root, then traverse only left of the tree.
        // case 3: if low >= root, then traverse only right of the tree;
        

        
        if(root == null)
            return 0;
        helper(root, low, high);
        // if( low <= root.val && root.val <= high){
        //     helper(root, low, high);
        // } else if (low >= root.val){
        //     if(low == root.val)
        //         result += root.val;
        //     helper(root.right, low, high);
        // } else if(high <= root.val){
        //     if(high == root.val){
        //         result += root.val;
        //     }
        //     helper(root.left, low, high);
        // }
        
        return result;
    }
    
    void helper(TreeNode root, int low, int high){

        if(root == null)
            return;
        if( low <= root.val && root.val <= high)
            result += root.val;
        
        helper(root.left, low, high);
        helper(root.right, low, high);
        
    }
}