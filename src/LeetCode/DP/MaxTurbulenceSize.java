package LeetCode.DP;
/*
* A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

    For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
    OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.

That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.*/
public class MaxTurbulenceSize {
    public static int maxTurbulenceSize(int[] A) {
        int reln = 0;
        int max = 1;
        int i=0, j=i+1;
        for( ;j<A.length;){
            if(A[j-1]==A[j]){
                int len = (j-i);
                max = max>len?max:len;
                i=j;
                j++;
                reln = 0;
            }
            else if(reln==0){
                reln=A[j-1]>A[j]?1:-1;
                j++;
            }else{
                if(reln==1){
                    if(A[j-1]>A[j]){
                        int len = (j-i);
                        max = max>len?max:len;
                        i=j-1;
                        j++;
                    }else{
                        reln=-1;
                        j++;
                    }
                }else{
                    if(A[j-1]<A[j]){
                        int len = (j-i);
                        max = max>len?max:len;
                        i=j-1;
                        j++;
                    }else{
                        reln=1;
                        j++;
                    }
                }
            }
        }

        return max>(j-i)?max:j-i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,8,45,88,48,68,28,55,17,24};
        System.out.println( maxTurbulenceSize(arr));
    }
}

