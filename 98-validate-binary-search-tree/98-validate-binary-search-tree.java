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
   public boolean isValidBST(TreeNode root) {
        
        //Recursive
        // return validate(root, null, null);
        
        //Iterative using inorder property
        Stack<TreeNode> stack = new Stack();
        Integer prev = null;
        
        while(!stack.isEmpty() || root != null){
            
            //starting from root push all the left childs to stack
            //Once the left of a given root is popped, will be pushing right child to stack.
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            // get the last left child from the stack
            TreeNode top = stack.pop();
            //compare with prev element, and this should always be greater (which means root val), if not its not a BST return false;
            if(prev != null){
                System.out.println("Comparing: prev->"+prev+" | "+ top.val);
            }
            if(prev != null && top.val <= prev){
                return false;
            }
            
            //copy popped left value to prev and then move root to right of the popped element.
            prev = top.val;
            root = top.right;
        }
        return true;
        
    }
}