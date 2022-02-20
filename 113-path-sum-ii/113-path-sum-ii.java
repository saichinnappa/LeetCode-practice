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
    List<List<Integer>> allPaths = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return allPaths;
        List<Integer> currentPath = new ArrayList();
        helper(root, targetSum, currentPath);
        return allPaths;
    }
    
    void helper(TreeNode root, int sum, List<Integer> currentPath){
        if(root == null)
            return;
        currentPath.add(root.val);
        if(sum == root.val && root.left == null && root.right == null){
            allPaths.add(new ArrayList<>(currentPath));
        } else{
            helper(root.left, sum - root.val, currentPath);
            helper(root.right, sum - root.val, currentPath);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }
}