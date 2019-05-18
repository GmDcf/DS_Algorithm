package LeetCode.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Longest_Arithmetic_Sequence {
    public static int longestArithSeqLength(int[] A) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i<A.length; i++){
            ArrayList<Integer> list = map.getOrDefault(A[i],new ArrayList<Integer>());
            list.add(i);
            map.put(A[i],list);
        }

        Map<Integer, Integer> longest = new HashMap<>();
        int max = 2;
        for(int j=1; j<A.length; j++){
            for(int i=j-1; i>=0; i--){
                int diff = A[j]-A[i];
                ArrayList<Integer> list = map.getOrDefault(A[i]-diff, new ArrayList<Integer>());
                int submax = 0;
                {
                    for (int k = 0; k < list.size(); k++) {
                        int next = list.get(k);
                        Integer len = 0;
                        if (next < i) {
                            len = longest.getOrDefault(i * A.length + next,2);
                            submax = submax > len ? submax : len;
                        }
                    }

                }
               submax=submax==0?2:(submax+1);
                longest.put(j * A.length + i, submax);
                max = max > submax? max : submax;
            }
        }
        return max;

    }

    public static void main(String[] args) {
      //  int[] arr = new int[]{12,28,13,6,34,36,53,24,29,2,23,0,22,25,53,34,23,50,35,43,53,11,48,56,44,53,31,6,31,57,46,6,17,42,48,28,5,24,0,14,43,12,21,6,30,37,16,56,19,45,51,10,22,38,39,23,8,29,60,18};
       // int[] arr = new int[]{9,4,7,2,10};

        int[] arr = new int[]{44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28};
        System.out.println(longestArithSeqLength(arr));
    }
}
