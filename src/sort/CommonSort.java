package sort;

import java.util.Arrays;

/**
 * 极客时间上讲述的排序 包含 桶排序，计数，归并，快排，冒泡，插入，选择，以及单元性能测试
 * Created by yl on 2019/8/7.
 */
public class CommonSort {
    /**
     * 数组范围已知，分为相同大小的桶。所以这样的排序是针对特定的数据集的排序，而不是通用的。
     * @param arr
     * @return
     */
    public static int[] bucketSort(int[] arr){
        //1.扫描数据上下范围
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a : arr){
            min=min<a?min:a;
            max = max>a?max:a;
        }

        if(min<0){
            for(int i=0; i<arr.length; i++){
                arr[i]-=min;
            }
        }
        int scope = max - min+1;

        //桶大小为10 1.桶大小？2。什么数据结构如何实现桶？3。怎么排序 4。怎么归并结果
        int bucketNum = scope/10+1;
        //2.合理划分桶大小
        int[][] buckets = new int[bucketNum][10];

        for(int a:arr){
            int row = a/10;
            int column = a%10;

            buckets[row][column]=a;
        }
        //3。单个桶快排序
        for(int i=0; i<buckets.length; i++){
            quickSort(buckets[i]);
        }

        //4.合并结果


        return new int[]{0};
    }
    /** 计数排序，桶大小为1的桶排序
     * 适用范围1。非负整数；2。数据范围k比数据量n相差不大的情况。
     * @param arr
     * @return
     */
    public static int[] countSort(int[] arr){
        if(arr==null||arr.length==0){
            return arr;
        }
        //1.查找数据范围
        int max = 0;
        for(int a : arr){
            max = max>a?max:a;
        }

        //2.统计 易错，数组要max+1，才容得下
        int[] countArr = new int[max+1];

        for(int a:arr){
            countArr[a]++;
        }

        int order = 0;

        //3.累加
        for(int i=0; i<countArr.length; i++){
            order+=countArr[i];
            countArr[i]=order;
        }

        int[] res = new int[arr.length];

        //4.排序
        for(int a:arr){
            //易错，第几个<==>下标 之间的转换
            res[countArr[a]-1]=a;
            countArr[a]--;
        }

        return res;
    }

    public static int[] quickSort(int[] arr){
         helpQuickSort(arr,0, arr.length-1);
         return arr;
    }

    public static void helpQuickSort(int[]arr, int p, int q){
        if(p<q){
            int pivot = arr[q];
            int now = p-1;
            for(int i=p; i<q; i++){
                if(arr[i]<pivot){
                    int tmp = arr[i];
                    arr[i]=arr[++now];
                    arr[now]=tmp;
                }
            }
            arr[q]=arr[++now];
            arr[now]=pivot;
            helpQuickSort(arr,p,now-1);
            helpQuickSort(arr,now+1,q);
        }
    }


    public static int[] mergeSort(int[] arr){
        return mergeSortPart(arr,0, arr.length-1);
    }

    public static int[] mergeSortPart(int[] arr, int p, int q){
        if(p<q){
            int[] firstArr = mergeSortPart(arr, p, (p+q)/2);
            int[] secondArr = mergeSortPart(arr, (p+q)/2+1, q);
            return mergeTwoSortedPart(firstArr,secondArr);
        }
        return new int[]{arr[q]};
    }

    public static int[] mergeTwoSortedPart(int[] arr, int[] brr){
        int i=0, j=0, k=0;
        int[] res = new int[arr.length+brr.length];
        while (i<arr.length&&j<brr.length){
            if(arr[i]<brr[j]){
                res[k++]=arr[i++];
            }else {
                res[k++]=brr[j++];
            }
        }
        for(;i<arr.length;i++){
            res[k++]=arr[i];
        }

        for(;j<brr.length;j++){
            res[k++]=brr[j];
        }

        return res;
    }



    public static int[] bubbleSort(int[] arr){
        if(arr==null||arr.length==0||arr.length==1){
            return arr;
        }
        boolean hasSwap = true;
        for(int i=0; i<arr.length-1; i++){
            hasSwap = false;
            for(int j=0; j<arr.length-1-i; j++) {//每走一轮，上限位置减1，
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j+ 1] = arr[j];
                    arr[j] = tmp;
                    hasSwap = true;
                }
            }
            if(!hasSwap){
                return arr;
            }
        }
        return arr;

    }

    public static int[] insertSort(int[] arr){
        if(arr==null||arr.length==0||arr.length==1){
            return arr;
        }
        for(int i=1; i<arr.length; i++){
            int value = arr[i];
            int j= i -1;
            for( j =i-1; j>=0; j-- ){
                if(value<arr[j]){
                    arr[j+1]=arr[j];
                }else {
                    break;//跳出循环有两种：1.找到比当前值小的；2.最前面位置；在该处插入会忽略第二种情况。所以统一跳出循环插入。
                }
            }
            arr[j+1]=value;
        }
        return arr;
    }

    public static int[] selectSort(int[] arr){
        if(arr==null||arr.length==0||arr.length==1){
            return arr;
        }

        for(int i=0; i<arr.length; i++){
            int min = arr[i];
            int minId = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<min){
                    min=arr[j];
                    minId = j;
                }
            }
            int tmp = arr[minId];
            arr[minId] = arr[i];
            arr[i]=tmp;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] testArray_0 = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] testArray_1= new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] testArray_2 = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] testArray_3 = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] testArray_4 = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] testArray_5 = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] testArray_6 = new int[]{10,9,8,7,6,5,4,3,2,1};

        System.out.println(Arrays.toString(bubbleSort(testArray_0)));
        System.out.println(Arrays.toString(insertSort(testArray_1)));
        System.out.println(Arrays.toString(selectSort(testArray_2)));
        System.out.println(Arrays.toString(mergeSort(testArray_3)));
        System.out.println(Arrays.toString(quickSort(testArray_4)));

        int testNum = 10000;
        int testArrayLen = 2000;
        int[][] testArrays = new int[testNum][testArrayLen];
        for(int i=0; i<testNum; i++){
            for(int j=0; j<testArrayLen; j++){
                testArrays[i][j]=(int)(Math.random()*testArrayLen);
            }
        }
        long currentTime = System.currentTimeMillis();
        System.out.println("开始调用冒泡排序");
        for(int[] testArray : testArrays){
            bubbleSort(testArray);
        }
        System.out.println("冒泡排序用时="+(System.currentTimeMillis()-currentTime));

        for(int i=0; i<testNum; i++){
            for(int j=0; j<testArrayLen; j++){
                testArrays[i][j]=(int)(Math.random()*testArrayLen);
            }
        }
        long currentTime_1 = System.currentTimeMillis();
        System.out.println("开始调用插入排序");
        for(int[] testArray : testArrays){
            insertSort(testArray);
        }
        System.out.println("插入排序用时="+(System.currentTimeMillis()-currentTime_1));

        for(int i=0; i<testNum; i++){
            for(int j=0; j<testArrayLen; j++){
                testArrays[i][j]=(int)(Math.random()*testArrayLen);
            }
        }
        long currentTime_2 = System.currentTimeMillis();
        System.out.println("开始调用选择排序");
        for(int[] testArray : testArrays){
            selectSort(testArray);
        }
        System.out.println("选择排序用时="+(System.currentTimeMillis()-currentTime_2));

        for(int i=0; i<testNum; i++){
            for(int j=0; j<testArrayLen; j++){
                testArrays[i][j]=(int)(Math.random()*testArrayLen);
            }
        }
        long currentTime_3 = System.currentTimeMillis();
        System.out.println("开始调用归并排序");
        for(int[] testArray : testArrays){
           mergeSort(testArray);
        }
        System.out.println("归并排序用时="+(System.currentTimeMillis()-currentTime_3));


        for(int i=0; i<testNum; i++){
            for(int j=0; j<testArrayLen; j++){
                testArrays[i][j]=(int)(Math.random()*testArrayLen);
            }
        }
        long currentTime_4 = System.currentTimeMillis();
        System.out.println("开始调用快速排序");
        for(int[] testArray : testArrays){
            quickSort(testArray);
        }
        System.out.println("快速用时="+(System.currentTimeMillis()-currentTime_4));

        for(int i=0; i<testNum; i++){
            for(int j=0; j<testArrayLen; j++){
                testArrays[i][j]=(int)(Math.random()*testArrayLen);
            }
        }

        long currentTime_5 = System.currentTimeMillis();
        System.out.println("开始调用Arrays.sort排序");
        for(int[] testArray : testArrays){
            Arrays.sort(testArray);
        }
        System.out.println("Arrays.sort()用时="+(System.currentTimeMillis()-currentTime_5));


    }























}
