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

class Codec {
    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(Node root) {
        sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }
    
    private void serialize(StringBuilder sb, Node root) {
        if(root != null) {
            sb.append(String.valueOf(root.val)).append("-");
            int size = root.children.size();
            sb.append(String.valueOf(size)).append("#");
            
            for(Node node: root.children){
                serialize(sb, node);
            }
        } else
            sb.append("N").append("#");
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
		// Splitting with '#' result in array of [ node + '-' + noOfChildrenNodes] e.g ["1-4", "2-0", "3-2"]
        nodes.addAll(Arrays.asList(data.split("#"))); 
        return buildTree(nodes);
    }
    
    private Node buildTree(Queue<String> nodes) {
        Node cur = new Node();
    
        if(nodes.peek().equals("N"))
            return null;
        
		// Split again to get node value and no of childrens
        String[] curNode = nodes.poll().split("-");
        
        cur.val = Integer.valueOf(curNode[0]); // Node value
        int size = Integer.valueOf(curNode[1]); // No of children nodes
        
        List<Node> children = new ArrayList<>();
        for(int j = 0; j<size; j++) {
            Node child = buildTree(nodes);
            children.add(child);
        }
        cur.children = children;
        return cur;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));