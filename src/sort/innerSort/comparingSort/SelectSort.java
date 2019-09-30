package sort.innerSort.comparingSort;

import java.util.Arrays;

/**
 * Created by GmDcf on 2018/4/23.
 */
public class SelectSort {
    public static void select(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int p=0;
            int max = arr[0];

            for(int j=0; j<n-i; j++){
                if(arr[j]>max){
                    p=j;
                    max = arr[j];
                }
            }
            System.out.println("p="+p+",max="+max);
            int t = arr[n-1-i];
            arr[n-1-i]=max;
            arr[p]=t;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1,9};
        select(arr);
        System.out.println(Arrays.toString(arr));
    }
}
