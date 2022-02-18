//APPROACH 1: RECURSIVE
// if(root == null)
//     return result;
// inorderTraversal(root.left);
// result.add(root.val);
// inorderTraversal(root.right);
// return result;
//APPROACH 2 : ITERATIVE
Deque<TreeNode> stack = new LinkedList();
while(!stack.isEmpty() || root != null){
while(root != null){
stack.push(root);
root = root.left;
}
TreeNode top = stack.pop();
result.add(top.val);
root = top.right;
}
return result;