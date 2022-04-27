* }
*/
class Solution {
boolean isValid = true;
TreeNode pre = null;
public boolean isValidBST(TreeNode root) {
//Recursive
// helper(root);
// Iterative
if(root == null)
return false;
Deque<TreeNode> queue = new LinkedList<>();
TreeNode pre = null;
// queue.offer(root);
while(!queue.isEmpty() || root != null){
while(root != null){
queue.push(root);
root = root.left;
}
TreeNode first = queue.pop();
if(pre != null){
if(pre.val >= first.val){
return false;
}
pre = first;
}
if(pre == null){
pre = first;
}
root = first.right;
}