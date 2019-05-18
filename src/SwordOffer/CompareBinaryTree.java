package SwordOffer;

/*递归的初始条件以及终止条件的判定*/
public class CompareBinaryTree {
    public static boolean compareBinaryTree(TreeNode tree1, TreeNode tree2){
         if(tree1==null||tree2==null){
             return false;
         }

        boolean result=false;
        if(tree1.val==tree2.val){
            result = helpCompare(tree1.left,tree2.left)&&helpCompare(tree1.right,tree2.right);
        }

        if(!result){
            result = compareBinaryTree(tree1.left,tree2)||compareBinaryTree(tree1.right, tree2);
        }
        return result;
    }

    public static boolean helpCompare(TreeNode tree1, TreeNode tree2){
        if(tree2==null){
            return true;
        }
        if(tree1==null){
            return false;
        }
       if(tree1.val!=tree2.val){
           return false;
       }
        return helpCompare(tree1.left,tree2.left)&&helpCompare(tree1.right, tree2.right);

    }

    public static void main(String[] args) {
            TreeNode tree1 = new TreeNode(8);
            tree1.left = new TreeNode(8);
            tree1.left.left=new TreeNode(9);
            tree1.left.right = new TreeNode(2);
            tree1.left.right.left = new TreeNode(4);
            tree1.left.right.right = new TreeNode(7);
            tree1.right = new TreeNode(7);

            TreeNode tree2 = new TreeNode(8);
            tree2.left = new TreeNode(9);
            tree2.right = new TreeNode(2);

        System.out.println(compareBinaryTree(tree1, tree2));
        System.out.println(compareBinaryTree(null, tree2));
        System.out.println(compareBinaryTree(tree1,null));
    }
}
