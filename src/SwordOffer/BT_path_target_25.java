package SwordOffer;

import java.util.LinkedList;
import java.util.List;

public class BT_path_target_25 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode rLeft = root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        rLeft.left = new TreeNode(4);
        rLeft.right = new TreeNode(7);

        printPathToSum(root,22);
    }

    public static void printPathToSum(TreeNode root, int sum){
        if(root==null){
            return;
        }

        LinkedList<TreeNode> path = new LinkedList<>();
        helpStorePath(root, sum, path);
    }

    private static void helpStorePath(TreeNode root, int sum, List<TreeNode> list){
        list.add(root);
        sum-=root.val;
        if(root.left==null&&root.right==null){
            if(sum==0) {
                helpPrint(list);
            }
        }else {
            if(root.left!=null){
                helpStorePath(root.left,sum,list);
            }
            if(root.right!=null){
                helpStorePath(root.right,sum,list);
            }
        }
        list.remove(list.size()-1);
        sum+=root.val;
    }

    private static void helpPrint(List<TreeNode> list){
        for(TreeNode node : list){
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
}
