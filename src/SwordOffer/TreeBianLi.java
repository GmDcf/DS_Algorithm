package SwordOffer;

import java.util.LinkedList;

public class TreeBianLi {
    public static void preOrderRe(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        //递归截止点
        while (root!=null||stack.size()!=0){
            while (root!=null){
                System.out.print(root.val+" ");
                stack.add(root.right);
                root = root.left;
            }

            if(stack.size()!=0){
                root = stack.removeLast();
            }

        }
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrderRe(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        //递归截止点
        while (root!=null||stack.size()!=0){
                while (root!=null){
                    stack.add(root);
                    root = root.left;
                }

                if(stack.size()!=0){
                    root = stack.removeLast();
                    System.out.print(root.val+" ");
                    root = root.right;
                }
        }
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void postOrderRe(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> flags = new LinkedList<>();
        //递归截止点
        while (root!=null||stack.size()!=0){
            // 阶段1，压栈
                while (root!=null){
                    stack.add(root);
                    flags.add(0);
                    root = root.left;
                }
            //阶段2，
               if(stack.size()!=0) {
                    int flag = flags.getLast();
                    root = stack.getLast();

                    if (flag == 0) {
                        flags.set(flags.size() - 1, 1);
                        root = root.right;  //更新root为rootright，由阶段1，完成压栈
                    } else if (flag == 1) { //出栈
                        System.out.print(stack.removeLast().val+" ");
                        flags.removeLast();
                        root = null;  //更新root
                    }
                }
        }
    }

    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    public static void main(String[] args) {
        /*
        * 8
       8     7
    9    2
       4     7*/
        /*TreeNode tree1 = new TreeNode(8);
        tree1.left = new TreeNode(8);
        tree1.left.left=new TreeNode(9);
        tree1.left.right = new TreeNode(2);
        tree1.left.right.left = new TreeNode(4);
        tree1.left.right.right = new TreeNode(7);
        tree1.right = new TreeNode(7);*/

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        postOrderRe(tree1);
        System.out.println();
        postOrder(tree1);
        System.out.println();
        preOrderRe(tree1);
        System.out.println();
        preOrder(tree1);
        System.out.println();
        inOrderRe(tree1);
        System.out.println();
        inOrder(tree1);

      /*  TreeNode tree2 = new TreeNode(8);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(2);*/

     /*   TreeNode tree2 = new TreeNode(1);
        tree2.right = new TreeNode(2);
        tree2.right.right = new TreeNode(3);

        System.out.println();
        postOrderRe(tree2);
        System.out.println();
        preOrderRe(tree2);
        System.out.println();
        inOrderRe(tree2);*/

    }
}
