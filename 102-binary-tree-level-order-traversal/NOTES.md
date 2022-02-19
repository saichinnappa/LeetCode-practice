//     public List<List<Integer>> levelOrder(TreeNode root) {
//         if(root == null)
//             return result;
//         Queue<TreeNode> queue = new ArrayDeque();
//         queue.offer(root);
//         while(!queue.isEmpty()){
//             List<Integer> list = new ArrayList();
//             int size = queue.size();
//             while(size != 0){
//                 TreeNode first = queue.poll();
//                 list.add(first.val);
//                 if(first.left != null)
//                     queue.offer(first.left);
//                 if(first.right != null)
//                     queue.offer(first.right);
//                 size--;
//             }
​
//         }
//         return result;
//     }
// }