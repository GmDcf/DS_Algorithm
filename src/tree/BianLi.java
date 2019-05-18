package tree;

import SwordOffer.TreeNode;

import java.util.Stack;

public class BianLi {
    /*
    * 树的迭代遍历需要考虑的问题：1.什么时候，如何更新当前节点 2.什么时候入栈 3.什么时候出栈
    * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rRight = root.right = new TreeNode(3);
        rRight.left = new TreeNode(5);
        TreeNode rLeft= root.left= new TreeNode(2);
        rLeft.right = new TreeNode(4);
        preOrder(root);
        inOrder(root);
        postOrder(root);
    }

    public static void preOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();

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

    public static void inOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();

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
    public static void postOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastpop = null;
        while(node!=null||stack.size()!=0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                TreeNode topNode = stack.peek();
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

}
