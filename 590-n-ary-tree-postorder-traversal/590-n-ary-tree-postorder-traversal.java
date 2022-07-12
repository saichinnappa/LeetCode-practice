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
    List<Integer> result =  new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root == null)
            return result;
        List<Node> children = root.children;
        for(int i = 0; i < children.size(); i++){
            postorder(children.get(i));
        }
        result.add(root.val);
        return result;
    }
}