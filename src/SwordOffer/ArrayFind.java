package SwordOffer;

/*.在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完
成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
* */
public class ArrayFind {
    public boolean find(int[][] array, int target){
        if(array==null||array.length==0){
            return false;
        }

        int row = 0; int column = array.length-1;
        while (row<=array.length&&column>0){
            if(array[row][column]>target){
                column--;
            }else if(array[row][column]<target){
                row++;
            }else {
                return true;
            }
        }

        return false;
    }
}
