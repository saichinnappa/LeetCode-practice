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

    public int minDepth(TreeNode root) {
//         if(root == null)       
//             return 0;
//         if(root.left == null && root.right == null)
//             return 1;
        
//         if(root.left == null)
//             return minDepth(root.right) + 1;
//         if(root.right == null)
//             return minDepth(root.left) + 1;
        
//         return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        
        
        Queue<TreeNode> queue = new LinkedList();
        int minDepth = Integer.MAX_VALUE;
        if(root == null)
            return 0;
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            while(size != 0){
                TreeNode first = queue.poll();    
                if(first.left != null)
                    queue.offer(first.left);
                if(first.right != null)
                    queue.offer(first.right);
                if(first.left == null && first.right == null){
                    minDepth = Math.min(minDepth, level);
                }
                size--;    
            }
            
        }
        return minDepth;
    }
}