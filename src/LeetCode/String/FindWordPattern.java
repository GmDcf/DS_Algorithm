package LeetCode.String;

import java.util.ArrayList;

import java.util.List;
/*You have a list of words and a pattern, and you want to know which words in words matches the pattern.

        A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

        (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

        Return a list of the words in words that match the given pattern.

        You may return the answer in any order.
        Example 1:

        Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
        Output: ["mee","aqq"]
        Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
        "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
        since a and b map to the same letter.
        */
public class FindWordPattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        char[] chpat = pattern.toCharArray();
        outter:
        for(String word:words){
            char[] wToP = new char[127];
            char[] pTow = new char[127];
            char[] cs = word.toCharArray();
            for(int i=0; i<cs.length;i++){
                char c = chpat[i];
                if(pTow[c]!='\u0000'){
                    if(pTow[c]!=cs[i]){
                        continue outter;
                    }
                }else{
                    if(wToP[cs[i]]!='\u0000'){
                        continue outter;
                    }
                    pTow[c]=cs[i];
                    wToP[cs[i]]=c;
                }
            }
            res.add(word);
        }
        return res;
    }

    public static void main(String[] args) {
        FindWordPattern fp = new FindWordPattern();
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        System.out.println((fp.findAndReplacePattern(words,"abb")));

    }
}
