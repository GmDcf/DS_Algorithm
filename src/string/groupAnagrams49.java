package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yanglong09
 * @date 2019/10/9.
 */
public class groupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> strToStrs = new HashMap<>();
        for(String str : strs){
            char[] cs = str.toCharArray();
            int[] count = new int[26];
            for(char c : cs){
                count[c-'a']++;
            }

            StringBuffer key = new StringBuffer();
            for(int i=0;i<26;i++){
                if(count[i]!=0) {
                    key.append(i+'a').append(count[i]);
                }
            }

            String keyval = key.toString();
            if(strToStrs.containsKey(keyval)){
                strToStrs.get(keyval).add(str);
            }else {
                LinkedList<String> list = new LinkedList<>();
                list.add(str);
                strToStrs.put(keyval, list);
            }
        }

        List<List<String>> res = new LinkedList<>();
        for(Map.Entry<String, LinkedList<String>> entry : strToStrs.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }
}
