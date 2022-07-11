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
        if(root == null)
            return root;
        
        Deque<Node> queue = new LinkedList<>(); 
        root.next = null;
        queue.offer(root);
        // queue.offer(root.left);
        // queue.offer(root.right);
        while(!queue.isEmpty()){
            Node prev = null;
            int size = queue.size();
            while(size != 0){
                Node first = queue.poll();
                if(prev == null)
                    prev = first;
                else{
                    prev.next = first;
                    prev = first;
                }
                if(first.left != null)
                    queue.offer(first.left);
                if(first.right != null)
                    queue.offer(first.right);
                size--;
            }
            prev.next = null;
            
        }
        
        return root;
    }
}