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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        if(root == null)
            return list;
        
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<Integer>();
            while(size != 0){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                size--;
            }
            if(levelList.size() > 0)
                list.add(levelList);
        }
        
        return list;
    }
}