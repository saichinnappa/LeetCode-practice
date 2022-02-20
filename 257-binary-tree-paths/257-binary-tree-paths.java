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
    List<String> result = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        // StringBuilder sb = new StringBuilder();
        helper(root, "");
        return result;
    }
    
    void helper(TreeNode root, String sb){
        if(root == null)
            return;
       sb += root.val;
        if(root.left == null && root.right == null)
            result.add(sb);
        else{
            sb += "->";
        }
        
            helper(root.left, sb);
            helper(root.right, sb);
        // System.out.println(sb.toString());
    }
}