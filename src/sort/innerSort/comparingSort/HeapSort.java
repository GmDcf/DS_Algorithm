package sort.innerSort.comparingSort;

/**
 * @author GmDcf
 * @Date on 2018/9/6.
 * 因为数组下标初始值为0这个特殊情况，
 * 导致堆中元素和左右子元素的下标关系为：
 *  i , left = i*2+1, right = i*2+2
 *  eg:
 *                  0
 *          1              2
 *     3        4      5      6
 * 实际中一般是
 *                  1
 *          2               3
 *
 *
 *
 */
import java.util.Arrays;

import static utils.Swap.*;
public class HeapSort {

    Comparable[] arr;
    boolean maxOrMin;
    int size;

    //这样做是考虑分别创建最大堆和最小堆，
    //实际可以按最大堆创建，如果需要降序，将结果降序输出即可。
    public HeapSort(Comparable[] arr, boolean maxOrMin){
        if(( this.size=arr.length)==0){
            throw new IllegalArgumentException("输入数组大小必须大于零");
        }
         this.arr = arr;
         this.maxOrMin = maxOrMin;
    }
    /**
     * 维护堆的性质发生在堆顶元素被修改，而其他部分仍然保持堆的性质的情况下
     * @param index 堆顶元素下标
     * @param size 堆的大小，堆中元素是数组的子集
     */
    private void heapify( int index, int size){
            if(index>=0&&size>0){
                    Comparable get = arr[index];
                    int leftIndex,rightIndex;
                    boolean left=false,right=false;
                    if((leftIndex= 2*index+1)<size&&get.compareTo(arr[leftIndex])<0){
                        get = arr[leftIndex];
                        left = true;
                    }
                    if((rightIndex=2*index+2)<size&&get.compareTo(arr[rightIndex])<0){
                        get = arr[rightIndex];
                        right = true;
                    }
                    if(right){
                        swap(arr, index, rightIndex);
                        heapify(rightIndex,size);
                    }
                    else if(left){
                        swap(arr,index,leftIndex);
                        heapify(leftIndex,size);
                    }
            }
    }

    /**
     * 将一个数组构建为堆
     */
    private  void buildHeap(){
            for(int i=arr.length-1; i>=0; i--){
                heapify(i,arr.length);
            }
    }

    /**
     */
    public void heapSort(){
            buildHeap();
            while (size>0){
                swap(arr,0,--size);
                heapify(0,size);
            }
            if(!maxOrMin){
                for(int i=0; i<=arr.length/2; i++){
                        swap(arr, i, arr.length-1-i);
                }
            }
            System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{
                4,1,35,113,54,6846,51,36,464,13,1,354,84,3,51,3,13,-8,-73,23,62,77
        };
        //HeapSort heapSort = new HeapSort(arr, true);
        HeapSort heapSort = new HeapSort(arr, false);
        heapSort.heapSort();
    }
}
