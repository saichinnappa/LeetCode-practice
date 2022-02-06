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
    List<Integer> preList = new ArrayList<>();
    List<Integer> postList = new ArrayList<>();
    
    public boolean isSymmetric(TreeNode root) {
        
        
        // APPROACH 1: TRAVERSALS
        // Step 1: Do preorder and postorder
        // Step 2: reverse postorder and compare with preorder
        // preorder(root);
        // postorder(root);
        // Collections.reverse(postList);
        // return preList.equals(postList);
        
        // APPROACH 2: RECURSION
        // Step 1: Start from immediate left and right from the root.
        // Step 2: Compare left.left with right.right, and left.right with right.left.
        // return helper(root.left, root.right);
        
        // APPROACH 3: Iterative
        // Step 1: Use 
        
        if(root.left == null && root.right == null)
            return true;
        else if(root.left == null || root.right == null)
            return false;
        
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            
            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t1.right);
            stack.push(t2.left);
        }
        
        return true;
        
    }
    
    
    boolean helper(TreeNode left, TreeNode right){
        
        //If both left and right are null, it may be a leaf node, so return true;
        if(left == null && right == null)
            return true;
        //One side of a tree cannot be null, fails symmetric condition
        if(left == null || right == null)
            return false;
        
        //If both nodes are not null, then both values must be same.
        if(left.val == right.val){
            //If both values are same, compare left child with right child and right child of left with left child of right.
            return helper(left.left, right.right) && helper(left.right, right.left);
        } else{
            return false;
        }
    }
    
    
    void preorder(TreeNode root){
        if(root == null){
            preList.add(null);
            return;
        }
        preList.add(root.val);
        preorder(root.left);
        preorder(root.right);
            
    }
    
    
    void postorder(TreeNode root){
        if(root == null){
            postList.add(null);
            return;
        }
        postorder(root.left);
        postorder(root.right);
        postList.add(root.val);
    }
    
}
