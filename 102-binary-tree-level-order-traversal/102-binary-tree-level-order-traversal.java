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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList();
            int size = queue.size();
            while(size > 0){
                TreeNode top = queue.poll();
                list.add(top.val);
                if(top.left != null){
                    queue.offer(top.left);
                }
                if(top.right != null){
                    queue.offer(top.right);
                }
                size--;
            }
            if(list.size() > 0)
                result.add(list);
        }
        return result;
    }
}

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
// class Solution {
    
//     List<List<Integer>> result = new ArrayList();
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         if(root == null)
//             return result;
        
//         Queue<TreeNode> queue = new ArrayDeque();
//         queue.offer(root);
        
//         while(!queue.isEmpty()){
//             List<Integer> list = new ArrayList();
//             int size = queue.size();
//             while(size != 0){
//                 TreeNode first = queue.poll();
//                 list.add(first.val);
//                 if(first.left != null)
//                     queue.offer(first.left);
//                 if(first.right != null)
//                     queue.offer(first.right);
//                 size--;
//             }

            
//         }
        
        
        
//         return result;
//     }
// }