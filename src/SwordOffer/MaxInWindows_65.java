package SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*区别滑动窗口的最大值和滑动窗口最大k个值*/
public class MaxInWindows_65 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,2,6,2,5,1};
        System.out.println((maxInWindws(arr,3)));
    }

    public static ArrayList<Integer> maxInWindws(int[] arr, int size){
        if(arr==null||size<=0||arr.length<size){
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<Integer> window = new ArrayList<>();

        for(int i=0; i<arr.length; i++){

            while (!window.isEmpty()&&arr[i]>=arr[window.get(window.size()-1)]){
                window.remove(window.size()-1);
            }

            if (!window.isEmpty()&&(i-window.get(0)+1)>size){ // 用if，是因为每次只入一个数字，而且每次入队列后，都会判断该条件，所以最多只有一个不符合
                window.remove(0);
            }

            window.add(i);

            if(i>=size-1) {     // 窗口长度不足 size，不存在最大值          //先考虑清楚，是比较长度还是比较下标
                results.add(arr[window.get(0)]);
            }
        }

        return results;
    }
}
