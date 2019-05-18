package utils;

import static sort.innerSort.comparingSort.InsertingSort.shellInsertingSort;

/**
 * @author GmDcf
 * @Date on 2018/9/5.
 */
public class binarySearching {
    public static void findEqual(){}
    public static int findFirstLargerThan(Comparable[] arr, int left, int right, Comparable target){
        if(left<0||right>=arr.length){
            throw new ArrayIndexOutOfBoundsException("index out of bounds of input arr");
        }

        if(left>right) {
            throw new IllegalArgumentException("left index must be less than right index");
        }

        while (left<=right){
            int mid = (right-left)/2+left;
            if(arr[mid].compareTo(target)>0){
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static int findLastLessThan(Comparable[] arr, int left, int right, Comparable target){
        if(left<0||right>=arr.length){
            throw new ArrayIndexOutOfBoundsException("index out of bounds of input arr");
        }

        if(left>right){
            throw new IllegalArgumentException("left index must be less than right index");
        }
        while (left<=right){
            int mid = (right-left)/2+left;
            if(arr[mid].compareTo(target)>=0){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{
                4,1,35,113,54,6846,51,36,464,1,13,1,354,84,3,51,3,13
        };

        shellInsertingSort(arr,2);

        for(Integer i : arr){
            int biggerIndex = findFirstLargerThan(arr,0, arr.length-1, i);
            int smallerIndex = findLastLessThan(arr, 0, arr.length-1, i);
            System.out.println("num "+i+"' first larger and smaller:");
            if(smallerIndex>=0){
                System.out.println(" last less than is at index="+smallerIndex+", num="+arr[smallerIndex]);
            }else {
                System.out.println(" last less than is at index="+smallerIndex);
            }

            if(biggerIndex<arr.length){
                System.out.println(" first bigger than is at index="+biggerIndex+", num="+arr[biggerIndex]);
            }else {
                System.out.println(" first bigger than is at index="+biggerIndex);
            }
        }




    }
}
