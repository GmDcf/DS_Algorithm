package LeetCode.DP;

public class Plus_Sign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] zeros = new int[N][N];
        for(int[] iarr:mines){
            zeros[iarr[0]][iarr[1]]=1;
        }
        int max = 0;
        int[] ups = new int[N];
        int[] downs = new int[N];
        int[] lefts = new int[N];
        int[] rights = new int[N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(zeros[i][j]!=1){
                    int up = upLen(zeros, i, j, ups);
                    int down = downLen(zeros, i, j, downs);
                    int left = leftLen(zeros, i, j, lefts);
                    int right = rightLen(zeros, i, j, rights);
                    int min = Math.min(up,down);
                    min = Math.min(min,left);
                    min = Math.min(min,right);
                    max = Math.max(max,min);
                }
            }
        }
        return max;
    }
    public int upLen(int[][] mines, int i, int j, int[] ups){
        if(mines[i][j]==0){
            if(ups[i]==0)
                return ups[i]=i>0?1+upLen(mines,i-1,j, ups):1;
            else
                return ups[i];
        }
        return 0;

    }
    public int downLen(int[][] mines, int i, int j, int[] downs){
        if(mines[i][j]==0){
            if(downs[i]==0)
            return downs[i]=i<mines.length-1?1+downLen(mines,i+1,j,downs):1;
        else
            return downs[i];
        }
        return 0;
    }
    public int leftLen(int[][] mines, int i, int j, int[] lefts){
        if(mines[i][j]==0){
            if(lefts[j]==0)
                return lefts[j]=j>0?1+leftLen(mines,i,j-1,lefts):1;
            else
                return lefts[j];
        }
        return 0;
    }
    public int rightLen(int[][] mines, int i, int j, int[] rights){
        if(mines[i][j]==0){
            if(rights[j]==0)
                return rights[j]=j<mines.length-1?1+rightLen(mines,i,j+1,rights):1;
            else
                return rights[j];
        }
        return 0;
    }

    public static void main(String[] args) {
        Plus_Sign plus_sign = new Plus_Sign();
        System.out.println(plus_sign.orderOfLargestPlusSign(5,new int[][]{{4,2}}));
        System.out.println(plus_sign.orderOfLargestPlusSign(2,new int[][]{}));
        System.out.println(plus_sign.orderOfLargestPlusSign(1,new int[][]{{0,0}}));
    }
}

