}
root = first.right;
}
return isValid;
}
void helper(TreeNode root){
if(root == null)
return;
helper(root.left);
if(pre != null){
if(pre.val >= root.val){
isValid = false;
}
pre = root;
}
if(pre == null)
pre = root;
helper(root.right);
}
}