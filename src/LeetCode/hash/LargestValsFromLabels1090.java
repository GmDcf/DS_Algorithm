package LeetCode.hash;

import java.util.*;

/**
 * @author yanglong09
 * @date 2019/9/20.
 */
public class LargestValsFromLabels1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        TreeMap<Integer, HashMap<Integer, HashSet<Integer>>> valuesToLablesToIndexs = new TreeMap<>();

        for(int i=0; i<values.length; i++){
            if(!valuesToLablesToIndexs.containsKey(values[i])){
                valuesToLablesToIndexs.put(values[i], new HashMap<>());
            }
            HashMap<Integer, HashSet<Integer>> labelsToIndexs = valuesToLablesToIndexs.get(values[i]);

            if(!labelsToIndexs.containsKey(labels[i])){
                labelsToIndexs.put(labels[i], new HashSet<>());
            }

            HashSet<Integer> indexs = labelsToIndexs.get(labels[i]);
            indexs.add(i);
        }

        Set<Map.Entry<Integer, HashMap<Integer, HashSet<Integer>>>> entrySet = valuesToLablesToIndexs.descendingMap().entrySet();
        Set<Integer> resIndexs = new HashSet<>();

        for(Map.Entry<Integer, HashMap<Integer, HashSet<Integer>>> entry : entrySet){
            if(num_wanted>0) {
                HashMap<Integer, HashSet<Integer>> labelsToIndexs = valuesToLablesToIndexs.get(entry.getKey());

            }else{
                break;
            }
        }

        int resnum = 0;
        for(int index : resIndexs){
            resnum+=values[index];
        }

        return resnum;
    }

    public static void main(String[] args) {
        LargestValsFromLabels1090 object = new LargestValsFromLabels1090();
        object.largestValsFromLabels(new int[]{1,2,3},new int[]{3,2,1},1,1);
    }
}
