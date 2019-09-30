package DP;

/**
 * @author yanglong09
 * @date 2019/9/30.
 */

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class Question279 {
    //1 递归 且 没有 限制 内部循环数量 -- 超时
    public int numSquares_0(int n) {
        int[] res = new int[n+1];
        res[1]=1;
        return helper(n,res);

    }

    public int helper(int i, int[] res){
        if(res[i]!=0) return res[i];

        int sqrt = (int)Math.sqrt(i);
        if(i==sqrt*sqrt) {
            res[i]=1;
            return 1;
        }

        int min = i;
        for(int j=1; j<=i/2;j++){
            int t = helper(j,res)+helper(i-j,res);
            min = min<t?min:t;
        }
        res[i]=min;
        return min;
    }

    //2.自底向上 且 没有 限制内部循环数量 986ms
    public int numSquares_1(int n) {
        int[] res = new int[n+1];
        res[1]=1;
        // return helper(n,res);

        for(int i=2; i<n+1; i++){

            int sqrt = (int)Math.sqrt(i);

            if(i==sqrt*sqrt) {
                res[i]=1;
            }
            else{
                int min = i;
                for(int j=1; j<i; j++){
                    int t = res[j]+res[i-j];
                    min = min<t?min:t;
                }
                res[i]=min;
            }
        }

        return res[n];
    }

    //3.自底向上 限制内部循环数量 503ms
    public int numSquares(int n) {
        int[] res = new int[n+1];
        res[1]=1;

        for(int i=2; i<n+1; i++){

            int sqrt = (int)Math.sqrt(i);
            if(i==sqrt*sqrt) {
                res[i]=1;
            }
            else{
                int min = i;
                for(int j=1; j<=i/2; j++){
                    int t = res[j]+res[i-j];
                    min = min<t?min:t;
                }
                res[i]=min;
            }
        }

        return res[n];
    }

    //4 自顶向上 找题意 减去很多不符合的情况 44ms
    // f(n) = min(f(n-i*i)+1), i = 1 to rount(sqrt(i)) ;
    public int numSquares_4(int n) {
        int[] res = new int[n+1];
        res[1]=1;

        for(int i=2; i<n+1; i++){

            int sqrt = (int)Math.sqrt(i);
            if(i==sqrt*sqrt) {
                res[i]=1;
            }
            else{
                int min = i;
                for(int j=1; j*j<=i; j++){
                    int t = res[i-j*j]+1;
                    min = min<t?min:t;
                }
                res[i]=min;
            }
        }

        return res[n];
    }

}
