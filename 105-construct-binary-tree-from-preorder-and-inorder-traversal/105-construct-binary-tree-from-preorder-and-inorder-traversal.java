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
            int preOrderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        

        return helper( preorder, 0, preorder.length - 1);
        
    }
    
    
    TreeNode helper(int[] preorder, int left, int right){
        if(left > right) return null;
        
        // TreeNode root = new TreeNode(preOrderIndex++);
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = helper(preorder, left, map.get(rootValue) - 1);
        root.right = helper(preorder, map.get(rootValue) + 1, right);
        return root;
    }
    
}