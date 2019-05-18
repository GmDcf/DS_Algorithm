package SwordOffer;

import java.util.Arrays;

/*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中
都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并
返回*/
public class BuildBianryTree {
    public static TreeNode buildBinary(int[] pre, int[] in){
       if(pre==null||pre.length==0){
           return null;
       }

      TreeNode node = new TreeNode(pre[0]);

       int index = 0;

       while(in[index]!=pre[0]){
           index++;
       }

       node.left = buildBinary(Arrays.copyOfRange(pre,1,index+1), Arrays.copyOfRange(in,0, index));
       node.right = buildBinary(Arrays.copyOfRange(pre,index+1,pre.length), Arrays.copyOfRange(in, index+1,in.length));
       return node;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(buildBinary(pre, in));
    }
}
