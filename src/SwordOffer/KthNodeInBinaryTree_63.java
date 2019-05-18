package SwordOffer;

import java.util.Stack;

public class KthNodeInBinaryTree_63 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rootl = root.left = new TreeNode(3);
        TreeNode rootll = rootl.left = new TreeNode(2);
        TreeNode rootlr = rootl.right = new TreeNode(4);

        TreeNode rootr = root.right = new TreeNode(7);
        TreeNode rootrr = rootr.right = new TreeNode(8);
        TreeNode rootrl = rootr.left = new TreeNode(6);

        System.out.println(findKthInBT(root,4));
        System.out.println(findKthInBT(root,7));
     //   System.out.println(findKthInBT(root,-1));
        System.out.println(findKthInBT(root,9));
    }

    public static int findKthInBT(TreeNode root, int k){
        if(root==null||k<=0){
            throw new IllegalArgumentException();
        }else {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while(node!=null||stack.size()!=0){
                while (node!=null){
                    stack.push(node);
                    node = node.left;
                }

                k--;
                node = stack.pop();
                if(k==0){
                    return node.val;
                }else {
                    if(node.right!=null){
                        node = node.right;
                    }else {
                        node = null;
                    }
                }

            }
        }
        throw new IllegalArgumentException("k is bigger than the number of node in the inputting tree");
    }

}
