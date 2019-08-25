package LeetCode.dp;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Moving_Stones_Until_Consecutive_II {
    public int[] numMovesStonesII(int[] stones) {
        Map<Integer, Integer> indexs = new HashMap<>();
        int max =0, min = 0, lmax=0, lmin=0;

        int index = 0;
        for(Integer vi:stones){
            indexs.put(vi,index);
            if(stones[lmax]<vi){
                lmax=index;
            }
            if(stones[max]<stones[lmax]){
                int t = max;
                max=lmax;
                lmax = t;
            }
            if(stones[lmin]>vi){
                lmin=index;
            }
            if(stones[min]>stones[lmin]) {
                int t = min;
                min = lmin;
                lmin = t;
            }
            index++;
        }

        return helpModify(stones,max,lmax,min,lmin,indexs);


    }
    public boolean isCon(int[] stones, int max, int min) {
        return (stones[max]-stones[min]+1)==stones.length;
    }


    public int[] helpModify(int[] stones, int max, int lmax, int min, int lmin, Map<Integer, Integer> indexs){
        if(isCon(stones,max,min)){
            return new int[]{0,0};
        }else {
            //max
            int[] mMax = null;
             {
                for (int i = stones[lmax] - 1; i > stones[min]; i--) {
                    if (!indexs.containsKey(i)) {
                        int ormax = stones[max];
                        indexs.remove(stones[max]);
                        indexs.put(i, max);
                        stones[max] = i;

                        mMax = helpModify(stones, lmax, max , min, lmin, indexs);
                        indexs.remove(i);
                        stones[max] = ormax;
                        indexs.put(ormax, max);
                        break;
                    }
                }
            }
            //min
            int[] mMin = null;
            if(stones[lmin]<stones[max]) {
                for (int i = stones[lmin] + 1; i < stones[max]; i++) {
                    if (!indexs.containsKey(i)) {
                        int ormin = stones[min];
                        indexs.remove(stones[min]);
                        indexs.put(i, min);
                        stones[min] = i;
                        mMin = helpModify(stones, max, lmax, lmin,min, indexs);
                        indexs.remove(i);
                        stones[min] = ormin;
                        indexs.put(ormin, min);
                        break;
                    }
                }
            }

            if(mMax==null&&mMin==null){
                return new int[]{0,0};
            }else {
                if(mMax==null) return new int[]{mMin[0]+1,mMin[1]+1};
                if(mMin==null) return new int[]{mMax[0]+1,mMax[1]+1};
                return new int[]{(mMax[0]<mMin[0]?mMax[0]:mMin[0])+1,(mMax[1]>mMin[1]?mMax[1]:mMin[1])+1};
            }
        }
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{7,4,9};
        int[] arr = new int[]{6,5,4,3,10};
        System.out.println(Arrays.toString(new Moving_Stones_Until_Consecutive_II().numMovesStonesII(arr)));
        System.out.println();
    }

}
