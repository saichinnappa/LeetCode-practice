/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return result;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size != 0){
                Node first = queue.poll();
                list.add(first.val);
                size--;
                List<Node> children = first.children;
                if(children!= null){
                    for(Node child : children){
                        queue.offer(child);
                    }
                }
            }
            if(list.size() > 0)
                result.add(list);
        }
        return result;
    }
}