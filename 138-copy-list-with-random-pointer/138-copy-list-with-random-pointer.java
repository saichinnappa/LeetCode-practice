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
    Map<Node, Node> map = new HashMap();
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node newNode = new Node(head.val);
        Node result = newNode;
        map.put(head, newNode);
        while(head != null){
            Node nextNode = null;
            Node randomNode = null;
            if(head.next != null && !map.containsKey(head.next)){
                map.put(head.next, new Node(head.next.val));
            }
                nextNode = map.get(head.next);
            
            if(head.random != null && !map.containsKey(head.random)){
                map.put(head.random, new Node(head.random.val));
            }
                randomNode = map.get(head.random);
            
            newNode.next = nextNode;
            newNode.random = randomNode;
            head = head.next;
            newNode = newNode.next;
        }
        return result;
    }
}