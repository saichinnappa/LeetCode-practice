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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null)
            return result;
        if(root.left == null && root.right == null){
            return Arrays.asList(root.val);
        }
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                TreeNode first = queue.poll();
                if(size - 1 == 0){
                    result.add(first.val);
                }
                if(first.left != null)
                    queue.offer(first.left);
                if(first.right != null)
                    queue.offer(first.right);
                size--;
            }
        }
                    
            return result;
            
        
    }
}