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
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            if(sb.length() > 0)
                sb.append(",");
            TreeNode first = queue.poll();
            if(first == null){
                sb.append("null");
                continue;
            }
            sb.append(first.val);
            queue.offer(first.left);
            queue.offer(first.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;
        Queue<TreeNode> queue = new LinkedList();
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        int i = 1;
        int n = data.length();
        while(!queue.isEmpty() && i < n){
            TreeNode left = null;
            TreeNode right = null;
            TreeNode root1 = queue.poll();
            if(!arr[i].equals("null")){
                left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(left);
            }
            i++;
            if(!arr[i].equals("null")){
                right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(right);
            }
            i++;
            root1.left = left;
            root1.right = right;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));