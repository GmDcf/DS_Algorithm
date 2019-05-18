package LeetCode.DP;

/*
* We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?

Note that our partition must use every number in A, and that scores are not necessarily integers.*/

public class Largest_Sum_of_Averages {

    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[] P = new double[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        //dp is supposed to be two-dimension matrix, but the state-transform shows that
        // it only need one dimension matrix
        double[] dp = new double[N];
        for (int i = 0; i < N; ++i)
            dp[i] = (P[N] - P[i]) / (N - i);

        // k is only for count how many times
        for(int k=1; k<K;k++){
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    //dp(i,k)=max{dp(i,k),max_{dp(j,k-1)+ave(i,j)}}
                    dp[i]=Math.max(dp[i],dp[j]+(P[j]-P[i])/(j-i));
                }
            }
        }
        return dp[0];
    }



    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println(new Largest_Sum_of_Averages().largestSumOfAverages(arr,4));
    }
}
