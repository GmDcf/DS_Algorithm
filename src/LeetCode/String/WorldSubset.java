package LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.

For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a.

Return a list of all universal words in A.  You can return the words in any order.*/

public class WorldSubset {
    public List<String> wordSubsets(String[] A, String[] B) {
        /*
        * first method :for each a in A, compare each b in B, time complexity is Na*Nb*26.
        *
        * second method :we first derive maxB for all b, then compare b with a, time complexity is (Na+Nb)*26.
        * by getting maxB first, we can reduce a compare with each b into a compare with one maxB
        * */
        List<String> res = new ArrayList<>();
        int[] mcountb = new int[26];
        for(int i=0; i<B.length; i++){
            int[] countb=countChar(B[i]);
            for(int j=0; j<26; j++){
                //because we only need the maxB, we can save the space complexity from Nb to 1.
                mcountb[j]=Math.max(countb[j],mcountb[j]);
            }
        }

        outter:
        for(String a:A){
            int[] counta=countChar(a);
                for(int i=0; i<26; i++){
                    if(counta[i]<mcountb[i]){
                        continue outter;
                    }
                }
            res.add(a);
        }

        return res;
    }

    public int[] countChar(String a){
        char[] ac = a.toCharArray();
        int[] counts = new int[26];
        for(char c:ac){
            counts[c-'a']++;
        }
        return counts;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] B = new String[]{"e","o"};
        WorldSubset subset = new WorldSubset();
        System.out.println(Arrays.toString(subset.wordSubsets(A,B).toArray()));
    }
}
