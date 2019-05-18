package sort.innerSort.comparingSort;

import static utils.binarySearching.*;
import java.util.Arrays;

/**
 * @author GmDcf
 * @Date on 2018/9/5.
 */

public class InsertingSort {
    /**直接插入
     *  分类 ------------- 内部比较排序
     *  数据结构 ---------- 数组
     *   最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
     *   最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
     *   平均时间复杂度 ---- O(n^2)
     *   所需辅助空间 ------ O(1)
     *   稳定性 ------------ 稳定
     *   */
    public static void directInsertingSort(Comparable[] arr){
        for(int i=0; i<arr.length; i++){
            //因为可能的移位，需要插入的值可能被覆盖，所以需要保存下来。
            Comparable tem = arr[i];
            for(int j=i-1; j>=0; j--){
                if(tem.compareTo(arr[j])<0){
                    //比需要插入的值下，则向后移位，与此同时相对地空位也向前移位了
                    arr[j+1]=arr[j];
                }else {
                    arr[j+1]=tem;
                    break;
                }
            }
        }
    }

    /*二分插入
    *  分类 ------------- 内部比较排序
    *  数据结构 ---------- 数组、
    * 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
    * 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
    * 平均时间复杂度 ---- O(n^2)
    * 所需辅助空间 ------ O(1)
    *  稳定性 ------------ 稳定*/
    public static void binaryInsertingSort(Comparable[] arr){
        for(int i=0; i<arr.length; i++){
            //因为可能的移位，需要插入的值可能被覆盖，所以需要保存下来。
            Comparable tem = arr[i];
            int index = findFirstLargerThan(arr, 0, i-1, tem);
            for(int j = i-1; j>=index; j--){
                 arr[j+1]=arr[j];
            }
            arr[index] = tem;
        }
    }

    /*希尔排序
    *  分类 -------------- 内部比较排序
    *  数据结构 ---------- 数组
    *  最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
    *  最优时间复杂度 ---- O(n)
    *  平均时间复杂度 ---- 根据步长序列的不同而不同。
    *  所需辅助空间 ------ O(1)
    * 稳定性 ------------ 不稳定
    * 希尔排序是不稳定的排序算法，虽然一次插入排序是稳定的，
    * 不会改变相同元素的相对顺序，但在不同的插入排序过程中，
    * 相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱。*/

    /**
     *
     * @param arr 待排序数组
     * @param factor 收缩率
     */
    public  static void shellInsertingSort(Comparable[] arr, int factor){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("input arr is illegal");
        }

        if(factor<=0){
             throw new IllegalArgumentException("factor must larger than 0");
        }
        //默认初始增量
        int h = arr.length/2;

        while (h >= 1){
            for (int i = h; i < arr.length; i++) {
                int j = i - h;
                Comparable temp = arr[i];
                while (j >= 0 && temp.compareTo(arr[j])<0) {
                    arr[j + h] = arr[j];
                    j = j - h;
                }
                arr[j + h] = temp;
            }
            h = h/factor;                  // 递减增量
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{
                4,1,35,113,54,6846,51,36,464,1,13,1,354,84,3,51,3,13
        };

       /* directInsertingSort(arr);
        System.out.println(Arrays.toString(arr));*/

        /*binaryInsertingSort(arr);
        System.out.println(Arrays.toString(arr));*/

        shellInsertingSort(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
