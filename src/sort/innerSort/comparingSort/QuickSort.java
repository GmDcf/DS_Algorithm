package sort.innerSort.comparingSort;

import java.util.Arrays;
import static utils.Swap.*;
/**
 * @author GmDcf
 * @Date on 2018/9/6.
 */
public class QuickSort {

    public static void simpleQucikSort(Comparable[] arr, int start, int end){
        //开始判断条件
        if(start<0||start>=arr.length||end<0||end>=arr.length){
            throw new IllegalArgumentException("index out of bounds");
        }
        if(start<end){
                if(start+1==end){
                    if(arr[start].compareTo(arr[end])>0){
                            swap(arr, start, end);
                    }
                }else{
                    Comparable pivot = arr[end];
                    int index = start-1;
                    for(int i=start; i<end; i++){
                            if(arr[i].compareTo(pivot)<0){
                                    swap(arr, ++index, i);
                            }
                    }
                    swap(arr, ++index, end);
                    //递归终止条件
                    if(index>start) {
                        simpleQucikSort(arr, start, index - 1);
                    }
                    //递归终止条件
                    if(index<end) {
                        simpleQucikSort(arr, index + 1, end);
                    }
                }
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        if(arr==null){
            throw new IllegalArgumentException();
        }

        if(start<end) {
            int p = partition(arr, start, end);

            if (p > 0) {
                quickSort(arr, 0, p - 1);
            }

            if (p < end) {
                quickSort(arr, p + 1, end);
            }
        }
    }


    private static int partition(int[] arr, int p, int q){
        if(p<q){
            int end = q;
            int pivot = arr[q];

            while (p<q){
                while (p<q&&arr[p]<=pivot){  // >
                    p++;
                }

                while (p<q&&arr[q]>pivot){  //<=
                    q--;
                }

                if(p<q){
                    intSwap(arr,p++,q--); //同时需要更新p ，q指向下一个位置否则会死循环
                }
            }

            intSwap(arr,p ,end);
            return p;

        }else if(p==q){
            return p;
        }else {
            throw new IllegalArgumentException();
        }
    }



    public static void oneAxisDividedByTwoEnds(Comparable[] arr, int start, int end){
        if(start<0||start>=arr.length||end<0||end>arr.length){
            throw new IllegalArgumentException("index out of bounds");
        }
        if(start<end){
            if(start+1==end){
                if(arr[start].compareTo(arr[end])>0){
                    swap(arr, start, end);
                }
            }else{
                Comparable pivot = arr[end];
                int i=start, j=end-1;

                while (i<=j){
                    for(;i<=j; i++){
                            if(arr[i].compareTo(pivot)>=0){
                                break;
                            }
                    }

                    for(;j>=i; j--){
                        if(arr[j].compareTo(pivot)<0){
                            break;
                        }
                    }
                    if(j>=i) {
                        swap(arr, i, j);
                        i++;
                        j--;
                        //可以在这里更新i，j,因为交换后，i，j此时肯定不满足要求
                        //不更新在循环里面多判断一次
                    }
                }
                swap(arr,i,end);
                //递归终止条件
                if(i>start) {
                    simpleQucikSort(arr, start, i - 1);
                }
                //递归终止条件
                if(i<end) {
                    simpleQucikSort(arr, i + 1, end);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{
                4,1,35,113,54,6846,51,36,464,13,1,354,84,3,51,3,13,-8,-73,23,62,77
        };
        int[] arr1 = new int[]{
               2,2,2,1,1,1
        };
        simpleQucikSort(arr,0,arr.length-1);
      oneAxisDividedByTwoEnds(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        quickSort(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }
}
