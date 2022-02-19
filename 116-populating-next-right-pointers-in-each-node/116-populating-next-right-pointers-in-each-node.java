/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null || (root.left == null && root.right == null))
            return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            while(size != 0){
                Node first = queue.poll();
                if(first.left != null)
                    queue.offer(first.left);
                if(first.right != null)
                    queue.offer(first.right);
                if(pre == null)
                    pre = first;
                else{
                    pre.next = first;
                    pre = first;
                }
                size--;    
            }
        }
        
        return root;
    }
}