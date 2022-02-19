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
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            LinkedList<Integer> list = new LinkedList();
            int size = queue.size();
            while(size != 0){
                TreeNode first = queue.poll();
                if(first.left != null)
                    queue.offer(first.left);
                if(first.right != null)
                    queue.offer(first.right);
                if(level % 2 != 0){
                    list.addFirst(first.val);
                } else{
                    list.addLast(first.val);
                }
                size--;
            }
            level++;
            if(list.size() > 0)
                result.add(list);
        }
        return result;
    }
}