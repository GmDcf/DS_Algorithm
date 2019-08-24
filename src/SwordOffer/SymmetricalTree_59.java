package SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;

//判断一个二叉树 是不是对称的
public class SymmetricalTree_59 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode rLeft = root.left = new TreeNode(7);
        TreeNode rRight = root.right = new TreeNode(7);
        rLeft.left = new TreeNode(7);
        rLeft.right = new TreeNode(7);

        rRight.left = new TreeNode(7);
   //     rRight.right = new BinaryTreeNode(5);

        System.out.println(isSymmetrical(root));
    }

    public static boolean isSymmetrical(TreeNode node){
        ArrayList<String> leftFirstPreOder = new ArrayList<>();
        ArrayList<String> rightFirstPreOder = new ArrayList<>();

        LinkedList<TreeNode> leftFirst = new LinkedList<>();
        leftFirst.add(node);
        while (leftFirst.size()!=0){
            TreeNode tNode = leftFirst.remove(0);
            if(tNode!=null) {
                leftFirstPreOder.add(tNode.val + "");
                leftFirst.add(0, tNode.right);
                leftFirst.add(0, tNode.left);
            }
            else{
                leftFirstPreOder.add(" ");
            }

        }

        LinkedList<TreeNode> rightFirst = new LinkedList<>();
        rightFirst.add(node);
        while (rightFirst.size()!=0){
            TreeNode tNode = rightFirst.remove(0);
            if(tNode!=null) {
                rightFirstPreOder.add(tNode.val + "");
                rightFirst.add(0, tNode.left);
                rightFirst.add(0, tNode.right);
            }
            else{
                rightFirstPreOder.add(" ");
            }

        }
        return rightFirstPreOder.equals(leftFirstPreOder);

    }
}
