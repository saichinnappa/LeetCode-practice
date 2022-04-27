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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level= 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while(size != 0 ){
                size--;
                TreeNode first = queue.poll();
                if(level % 2 != 0){
                    list.addFirst(first.val);
                } else{
                    list.addLast(first.val);
                }
                if(first.left != null)
                    queue.offer(first.left);
                if(first.right != null)
                    queue.offer(first.right);
            }
            level++;
            if(list.size() > 0){
                result.add(list);
            }
            
        }
        return result;
    }
}