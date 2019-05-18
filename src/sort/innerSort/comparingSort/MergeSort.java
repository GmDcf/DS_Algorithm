package sort.innerSort.comparingSort;

import java.util.Arrays;

/**
 * @author GmDcf
 * @Date on 2018/9/6.
 */
public class MergeSort {
    public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{
                4,1,35,113,54,6846,51,36,464,13,1,354,84,3,51,3,13,-8,-73,23,62,77
        };
        int[] arr1 = new int[]{
                2,2,2,1,1,1
        };
        sort(arr1,0,arr.length-1);
        System.out.println(Arrays.toString(arr1));
    }
}
