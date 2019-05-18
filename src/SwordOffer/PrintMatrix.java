package SwordOffer;

/*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4
5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.*/

/*
* 这题不难，关键在于把复杂的多流程的程序，分解为多个单流程的程序块，把每一块，考虑清楚
* 1.这题是循环，循环首先弄清楚，循环开始和终止条件。
* 2.单次循环是怎样的一个过程。
* */
public class PrintMatrix {
    public static void printMatrix(int[][] nums){
        if(nums==null||nums.length<=0){
            return;
        }

        int columns = nums.length;
        int rows = nums[0].length;
        int start = 0;

        while (columns>2*start&&rows>2*start){
            helpPrint(nums, start);
            start++;
        }
        System.out.println();
    }

    public static void helpPrint(int[][] nums, int start) {
        //从左到右
        int rightBound = nums[start].length - 1 - start;
        //4 四步每一步都是在前一步成立的基础上，再加上自己的条件。
        //如果自己的条件不成立，就会被上一步包括
        for (int i = start; i <= rightBound; i++) { //1 start<=rB
            System.out.print(nums[start][i] + " ");
        }
        //从右上到右下
        int downBound = nums.length - 1 - start;
        if (start < downBound) {
            for (int i = start + 1; i <= downBound; i++) {//2 start<endY
                System.out.print(nums[i][rightBound] + " ");
            }
        }
        //从右下到左下
        if (rightBound > start && downBound > start) {
            for (int i = rightBound - 1; i >= start; i--) {//3 start>
                System.out.print(nums[downBound][i] + " ");
            }
        }
        //从左下到左上
        if (downBound-1>start&&rightBound<start){ //
            for (int i = downBound - 1; i > start; i--) {//4.start<rightBound-1
                System.out.print(nums[i][start] + " ");
            }
         }
    }

    public static void main(String[] args) {
        int[][] arr ={ {1,2,3,4},{ 5,6,7,8 }, {9,10,11,12},{13,14,15,16}};
        printMatrix(arr);

        int[][] arr1 = {{1,2,3,4}};
        printMatrix(arr1);
    }
}
