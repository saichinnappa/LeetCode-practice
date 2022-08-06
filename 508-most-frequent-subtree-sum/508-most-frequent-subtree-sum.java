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
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0, sum =0;
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    int helper(TreeNode root){
        if(root == null)
            return 0;
        int x = helper(root.left);
        int y = helper(root.right);
        sum = root.val + x + y;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
        
    }
}