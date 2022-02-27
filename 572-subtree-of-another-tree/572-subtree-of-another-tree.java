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
// class Solution {
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         if(root == null)
//             return false;
        
//         return isSameTree(root, subRoot) || isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
//     }
    
//     boolean isSameTree(TreeNode root, TreeNode subRoot){
//         if(root == null && subRoot == null)
//             return true;
//         if(root == null || subRoot == null)
//             return false;
//         return (root.val == subRoot.val) && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
//     }
    
// }


class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        return isSame(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSame(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;
        return r1.val==r2.val && isSame(r1.left,r2.left) && isSame(r1.right,r2.right);
    }
}