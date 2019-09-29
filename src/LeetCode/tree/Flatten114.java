package LeetCode.tree;

/**
 * @author yanglong09
 * @date 2019/9/29.
 */

/**
 * 二叉树展开为链表 二叉树先序遍历
 */
public class Flatten114 {
    public  void  flatten(TreeNode root){
        helpFlat(root);
    }

    public TreeNode helpFlat(TreeNode root){
        if(root!=null){
            TreeNode left = helpFlat(root.left);
            TreeNode right = helpFlat(root.right);
            root.left = null;
            if(left!=null){
                root.right = left;
                while (left.right!=null){
                    left = left.right;
                }
                left.right = right;
            }else{
                root.right =right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode5.right = treeNode6;
        Flatten114 flatten114 = new Flatten114();
        flatten114.flatten(treeNode1);
        System.out.println();
    }
}
