package LeetCode.String;

import java.util.HashMap;

public class Find_And_Replace_in_String {
    class Source_Target{
        String source;
        String target;
        Source_Target(String source, String target){
            this.source=source;
            this.target=target;
        }
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuffer sb = new StringBuffer();
        char[] cs = S.toCharArray();

        HashMap<Integer,Source_Target> source_targetHashMap = new HashMap<>();
        for(int i=0; i<indexes.length;i++){
            Source_Target source_target = new Source_Target(sources[i],targets[i]);
            source_targetHashMap.put(indexes[i],source_target);
        }

        int lastInsert = 0;
        for(int i=0; i< cs.length; i++){
            if(source_targetHashMap.containsKey(i)) {
                int index = i;
                Source_Target source_target = source_targetHashMap.get(index);
                char[] charSource = source_target.source.toCharArray();
                //first add chars last left
                for (int j = lastInsert; j < cs.length && j < index; j++) {
                    sb.append(cs[j]);
                }
                //second check out what's going on
                int p = index;
                int q = 0;
                // check index in range of array firstly
                while (p < cs.length && q < charSource.length && cs[p++] == charSource[q++]) {
                }
                // judge if satisfied
                if (q == charSource.length && p <= cs.length) {
                    sb.append(source_target.target);
                    //update lastinsert while match successfuly
                    lastInsert = p;
                } else {
                    if (p >= cs.length) {
                        return sb.toString();
                    }
                    //update lastinsert while match failed
                    lastInsert = index;
                }
            }
        }
        //final check if the loop out while the last part don't process
        while (lastInsert<cs.length){
            sb.append(cs[lastInsert++]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Find_And_Replace_in_String example = new Find_And_Replace_in_String();
        System.out.println(example.findReplaceString("abcd",new int[]{0,2},new String[]{"a","cd"},new String[]{"eee","ffff"}));
        System.out.println(example.findReplaceString("abcd",new int[]{0,2},new String[]{"ab","ec"},new String[]{"eee","ffff"}));
        System.out.println(example.findReplaceString("vmokgggqzp",new int[]{3,5,1},new String[]{"kg","ggq","mo"},new String[]{"s","so","bfr"}));
/*
* "vmokgggqzp"
[3,5,1]
["kg","ggq","mo"]
["s","so","bfr"]*/
    }
}
