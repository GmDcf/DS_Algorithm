package LeetCode.hash;

import java.util.*;

/**
 * Created by yl on 2019/8/24.
 */
public class EveryDayTemperature739 {
    /*[73, 74, 75, 71, 69, 72, 76, 73]*/
    public int[] dailyTemperatures(int[] T) {
        Set<Integer> unhandledIndex = new HashSet<>();
        int[] res = new int[T.length];
        for(int i=0; i<T.length; i++){
            for(Iterator<Integer> it = unhandledIndex.iterator();it.hasNext(); ){
                int j = it.next();
                if(T[i]>T[j]){
                    res[j]=i-j;
                    it.remove();
                }
            }
            unhandledIndex.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Long curT = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis()-curT);
    }
}
