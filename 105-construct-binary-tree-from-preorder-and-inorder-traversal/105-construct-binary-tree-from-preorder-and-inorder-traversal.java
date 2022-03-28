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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    TreeNode root = null;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        // root = new TreeNode(preorder[preIndex]);
        return helper(0, preorder.length - 1);
        // return root;
    }
    
    TreeNode helper(int left, int right){
        if(left > right)
            return null;
        int val = preorder[preIndex++];
       TreeNode root = new TreeNode(val);
        root.left = helper(left, map.get(val) - 1);
        root.right = helper(map.get(val) + 1, right);
        return root;
    }
}