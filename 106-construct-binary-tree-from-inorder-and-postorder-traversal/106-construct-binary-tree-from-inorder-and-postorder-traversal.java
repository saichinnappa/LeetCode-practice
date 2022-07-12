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
    Map<Integer, Integer> map = new HashMap<>();
    int index;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        this.postorder = postorder;
        this.index = postorder.length - 1;
        return helper(0, postorder.length - 1);
        
    }
    
    TreeNode helper(int start, int end){
        if(start > end)
            return null;
        int rootValue = postorder[index--];
        TreeNode root = new TreeNode(rootValue);
        root.right = helper(map.get(rootValue) + 1, end);
        root.left = helper(start, map.get(rootValue) - 1);
        return root;
    }
}