queue.offer(root);
int level = 0;
while(!queue.isEmpty()){
int size = queue.size();
LinkedList<Integer> list = new LinkedList();
while(size > 0){
TreeNode first = queue.poll();
if(first.left != null)
queue.add(first.left);
if(first.right != null)
queue.add(first.right);
if(level % 2 == 1){
list.addFirst(first.val);
} else{
list.addLast(first.val);
}
size--;
}
level++;
if(list.size() > 0)
result.add(list);
}
return result;
}
}