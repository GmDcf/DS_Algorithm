package tree.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yl on 2019/8/24.
 */
public class BTTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new LinkedList<>();
        if(root==null) return inorder;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode lastpop=null;
        while(stack.size()>0){
            TreeNode tmp = stack.peek();
            //***当上一个出栈的不是当前节点当左子节点且左子节点不为空时，继续往左子树走
            if(tmp.left!=null&&tmp.left!=lastpop){
                stack.push(tmp.left);
                tmp = tmp.left;
            }
            else{
                //***读取值，但先不出栈
                inorder.add(tmp.val);
                if(tmp.right!=null){
                    stack.push(tmp.right);
                }else{
                    lastpop = stack.pop();
                    //***右子节点为null，一直出栈，直到上一个出栈的节点不是栈顶节点的右节点。
                    while(stack.size()>0&&stack.peek().right==lastpop){
                        lastpop = stack.pop();
                    }

                }
            }

        }
        return inorder;
    }


}
