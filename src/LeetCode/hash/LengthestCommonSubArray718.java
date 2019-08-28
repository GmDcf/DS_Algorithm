package LeetCode.hash;

import java.util.Arrays;

/**
 * @author yanglong09
 * @date 2019/8/28.
 */
public class LengthestCommonSubArray718 {

    public int findLength(int[] A, int[] B) {
        int[][] ab = new int[A.length][B.length];
        int max = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]==B[0]){
                ab[i][0]=1;
            }
        }
        for(int j=0; j<B.length; j++){
            if(A[0]==B[j]){
                ab[0][j]=1;
            }
        }
        for(int i=1; i<A.length; i++){
            for(int j=1; j<B.length; j++){
                if(A[i]==B[j]){
                    ab[i][j]=ab[i-1][j-1]+1;
                }else {
                    ab[i][j]=0;
                }
                max = max>ab[i][j]?max:ab[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthestCommonSubArray718 intance = new LengthestCommonSubArray718();
        int[] A = new int[]{1,2,3,2,1,2,7,9,4,9,4,7,7,2,9};
        int[] B = new int[]{3,2,1,4,7,9,7,5,9,8,7,9,2,9,8,7,9};
        System.out.println(intance.findLength(A,B));
    }

}
