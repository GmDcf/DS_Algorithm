package SwordOffer;

/*
* 输入测试分三种
* 1.特殊--空指针，或者针对题目要求无意义的指针
* 2.边界测试，这里旋转零个，即升序情况
* 3.功能测试，一些特殊的例子，如重复值
* 4.性能测试
* */

public class minNumINRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        /*
        * 二分查找分两部分：
        * 1.right和left的移动，是mid，还是mid+1，或者mid-1,要根据查找的值是否可能出现在mid上确定。
        * 2.循环跳出的条件需要特别考虑，不同二分查找跳出不一样。
        * */
            while(array[left]>=array[right]){
                if(right-left<=1){
                    mid = right;
                    break;
                }//bug
                mid = (right-left)/2+left;  //bug?

                if(array[mid]>=array[left]&&array[mid]>array[right]){
                    left = mid;
                }else if(array[mid]<=array[right]&&array[mid]<array[left]){
                    right = mid;  //bug
                }else if(array[mid]==array[left]&&array[mid]==array[right]){
                    left++;  //bug最坏时间复杂度
                    right--;
                    mid = left;
                }

            }

        return array[mid];
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2= {10,11,2,3,4,5};
        int[] arr3 = {3,3,3,3,3,3,3,3};
        int[] arr4 =  {3,4,5,1,2};
        int[] arr = {1,0,1,1,1};

        System.out.println(minNumberInRotateArray(arr1));
        System.out.println(minNumberInRotateArray(arr2));
        System.out.println(minNumberInRotateArray(arr3));
        System.out.println(minNumberInRotateArray(arr4));
        System.out.println(minNumberInRotateArray(arr));
    }
}
