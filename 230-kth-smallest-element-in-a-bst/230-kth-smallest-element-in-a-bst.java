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
    List<Integer> list = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        // helper(root);
        Stack<TreeNode> stack = new Stack();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode top  = stack.pop();
            // System.out.println(top.val);
            list.add(top.val);
            
            root = top.right;
            // if(root != null && root.right != null)
            //     stack.push(root);
            
        }
        
        System.out.println(list);
       
        return list.get(k - 1);
    }
    void helper(TreeNode root){
         if(root == null)
            return;
                
        helper(root.left);
        list.add(root.val);

       helper(root.right);
    }
}