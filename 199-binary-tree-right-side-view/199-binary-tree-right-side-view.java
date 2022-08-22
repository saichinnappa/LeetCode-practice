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
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
                            
                result.add(queue.peek().val);
            while(size != 0){
                size --;
                TreeNode first = queue.poll();
                if(first.right != null)
                    queue.offer(first.right);
                if(first.left != null)
                    queue.offer(first.left);
            }
        }
        
        return result;
    }
}