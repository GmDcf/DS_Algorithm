package SwordOffer;

import java.util.LinkedList;
import java.util.List;

public class FindTargetSum {
    public static void findPathTargetSum(TreeNode node, int target, LinkedList<TreeNode> path){
         if(node==null){
             return;
         }

         path.add(node);

         if(node.left==null&&node.right==null){
              if(target-node.val==0){
                  print(path);
              }
         }

         if(node.left!=null){
             findPathTargetSum(node.left, target-node.val,path);
         }

         if(node.right!=null){
             findPathTargetSum(node.right, target-node.val,path);
         }

         path.removeLast();
    }

    public static void findPathTargetSumRec(TreeNode node, int target, LinkedList<TreeNode> path){
         if(node==null){
             return;
         }

         while (node!=null||path.size()!=0){
             while (node!=null){
                 path.add(node);
                 target-=node.val;
                 node = node.left;
             }

             if(path.size()!=0){
                 node= path.getLast();
                 if(node.right==null){
                     if(target==0){
                         print(path);
                     }
                     target+=node.val;
                     path.removeLast();
                     node = null;
                 }else {
                     node = node.right;
                 }
             }
         }
    }


    public static void print(List<TreeNode> list){
        for(TreeNode node : list){
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(5);
            root.right = new TreeNode(12);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(7);
          findPathTargetSum(root,19, new LinkedList<TreeNode>());
           // findPathTargetSumRec(root, 22, new LinkedList<>());
    }
}
