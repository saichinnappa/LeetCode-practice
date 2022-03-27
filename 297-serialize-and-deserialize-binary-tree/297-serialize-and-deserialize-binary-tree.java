/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null)
            return sb.toString();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            if(sb.length() > 0)
                sb.append(",");
            if(first != null){
                sb.append(first.val);
                queue.offer(first.left);
                queue.offer(first.right);
            } else{
                sb.append("null");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int n = data.length();
        if(n == 0)
            return null;
        int i = 0;
        String[] arr = data.split(",");
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode left = null;
            TreeNode right = null;
            TreeNode r1 = queue.poll();
            if(!arr[i].equals("null")){
                left  = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(left);
            }
            i++;
            if(!arr[i].equals("null")){
                right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(right);
            }
            i++;
            r1.left = left;
            r1.right = right;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));