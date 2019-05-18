package SwordOffer;

import SwordOffer.TreeNode;

public class MirrorOfBT {
public static void main(String[] args) {

        }

public static void MirrorRecursively(TreeNode root){
        if(root==null){
        return;
        }

        if(root.left==null&&root.right==null){
        return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        MirrorRecursively(root.left);
        MirrorRecursively(root.right);
        }
        }
