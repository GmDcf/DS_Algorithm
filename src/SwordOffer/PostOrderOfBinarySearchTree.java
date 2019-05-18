package SwordOffer;

import java.util.Arrays;

public class PostOrderOfBinarySearchTree {
    public static boolean isBinarySearchTree(int[] arr){
        if(arr==null||arr.length<=0){
            return false;
        }
        return helpJudge(arr);
    }

    public static boolean helpJudge(int[] arr){
        if(arr==null||arr.length==0){
            return true;
        }
        int root = arr[arr.length-1];

        int i=0;
        while (i<arr.length-1&&arr[i]<root){
            i++;
        }

        int j= i;
        while (j<arr.length-1){
            if(arr[j++]<root){
                return false;
            }
        }

        boolean flag = helpJudge(Arrays.copyOfRange(arr,0,i));

        if(flag){
            flag = helpJudge(Arrays.copyOfRange(arr,i,arr.length-1));
            Arrays.copyOf(arr,3);
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,6,9,11,10,8};
        System.out.println(isBinarySearchTree(arr));
        int[] arr1 = {7,4,6,5};
        System.out.println(isBinarySearchTree(arr1));
    }
}
