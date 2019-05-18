package utils;

/**
 * @author GmDcf
 * @Date on 2018/9/6.
 */
public class Swap {
    public  static void swap(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void intSwap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
