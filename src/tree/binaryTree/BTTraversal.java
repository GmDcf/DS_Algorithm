package tree.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yl on 2019/8/24.
 */
public class BTTraversal {
    /**
     *
     * @param node
     */
    public static void preOrder(BinaryTreeNode node){
        Stack<BinaryTreeNode> stack = new Stack<>();

        while(node!=null||stack.size()!=0){
            while(node!=null){
                stack.push(node);
                System.out.print(node.val+" ");
                node=node.left;
            }

            if(!stack.isEmpty()){
                node=stack.pop().right;
            }

        }
        System.out.println();
    }

    /**
     * offcial impl
     * @param node
     */
    public static void inOrder(BinaryTreeNode node){
        Stack<BinaryTreeNode> stack = new Stack<>();

        while(node!=null||stack.size()!=0){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }

            if(!stack.isEmpty()){
                node=stack.pop();
                System.out.print(node.val+" ");
                node=node.right;
            }

        }
        System.out.println();
    }

    /**
     * offcial impl
     * @param node
     */
    public static void postOrder(BinaryTreeNode node){
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode lastpop = null;
        while(node!=null||stack.size()!=0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                BinaryTreeNode topNode = stack.peek();
                if(topNode.right==lastpop||topNode.right==null){
                    System.out.print(topNode.val+" ");
                    stack.pop();
                    lastpop=topNode;
                }else{
                    node=topNode.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * my impl
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> inorder = new LinkedList<>();
        if(root==null) return inorder;

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        BinaryTreeNode lastpop=null;
        while(stack.size()>0){
            BinaryTreeNode tmp = stack.peek();
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

    /**
     * myimpl
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(BinaryTreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        BinaryTreeNode lastpop = null;

        while(stack.size()>0){
            BinaryTreeNode now = stack.peek();

            //***只有当前节点的左节点不是上次出栈的节点，表示是第一次访问。防止反复左节点入栈，死循环。
            while(now.left!=lastpop&&now.left!=null){
                stack.push(now.left);
                now = now.left;
            }

            if(now.right==null){
                //出当前节点
                res.add(now.val);
                stack.pop();
                //出栈直到上一个出栈节点不是栈顶节点的右节点
                while(stack.size()>0&&stack.peek().right==now){
                    now =  stack.pop();
                    res.add(now.val);
                }
                //记录上一次出栈的节点
                lastpop = now;
            }else{
                stack.push(now.right);
            }

        }
        return res;
    }
}
