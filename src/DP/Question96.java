package DP;

/**
 * @author yanglong09
 * @date 2019/9/30.
 */

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example, Given n = 3, there are a total of 5 unique BST's.

 1 3 3 2 1 \ / / / \
 3 2 1 1 3 2 / / \
 2 1 2 3
 */
public class Question96 {
    public int numTrees(int n) {
        //注意判断边界
        int[][] con = new int[n+2][n+2];
        // Arrays.fill(con,-1); 只能填充一维数组
        return  helper(1,n,con);
    }
    public int helper(int start, int end, int[][] con){
        if(con[start][end]!=0) return con[start][end];
        int count = 0;
        if(start-1==end||start==end) return 1;

        int i=start;
        while(i<=end){
            //(start,i).(i,end),(start,i-1)(i,end)都会产生调用自己的问题
            int left = helper(start,i-1,con);
            int right = helper(i+1,end,con);
            count+=left*right;
            i++;
        }
        con[start][end]=count;
        return count;
    }
}
