package test;


import sort.CommonSort;

import java.util.Arrays;

/**
 * Created by yl on 2019/8/13.
 */
public class CountSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,0,2,3,0,3};
        int[] brr = new int[]{9,8,6,6,5,4,2,2,1,0};
        System.out.println(Arrays.toString(CommonSort.countSort(arr)));
        System.out.println(Arrays.toString(CommonSort.countSort(brr)));
    }
}
