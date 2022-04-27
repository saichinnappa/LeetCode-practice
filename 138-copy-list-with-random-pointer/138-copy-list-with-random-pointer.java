/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(head.val);
        Node result = newNode;
        map.put(head, newNode);
        while(head != null){
            Node next = null;
            Node random = null;
            if(head.next != null && map.get(head.next) == null){
                map.put(head.next, new Node(head.next.val));
            }
            next = map.get(head.next);
            if(head.random != null && map.get(head.random) == null){
                map.put(head.random, new Node(head.random.val));
            }
            random = map.get(head.random);
            
            newNode.next = next;
            newNode.random = random;
            newNode = newNode.next;
            head = head.next;
        }
        return result;
    }
}