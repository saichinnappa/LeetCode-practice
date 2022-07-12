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
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] preorder;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper( 0, preorder.length - 1);
    }
    
    TreeNode helper(int start, int end){
        if(start > end)
            return null;
        if(index >= preorder.length)
            return null;
        int rootValue = preorder[index++];
        TreeNode root = new TreeNode(rootValue);
        root.left = helper( start, map.get(rootValue) - 1);
        root.right = helper( map.get(rootValue) + 1, end);
        return root;
    }
}