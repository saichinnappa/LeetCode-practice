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
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return result;
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList();
            while(size != 0){
                TreeNode first = queue.poll();
                if(first.left != null)
                    queue.add(first.left);
                if(first.right != null)
                    queue.add(first.right);
                size--;
                if(level % 2 == 0){
                    list.addLast(first.val);
                } else
                    list.addFirst(first.val);
            }
            level++;
            if(list.size() > 0){
                result.add(list);
            }
        }
        
        return result;
    }
}