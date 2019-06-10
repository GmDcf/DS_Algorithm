package LeetCode.String;

/*Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]*/
import java.util.*;
public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> group_anagrams = new HashMap<>();
        for(String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String tmp = new String(cs);
            if(group_anagrams.containsKey(tmp)){
                List<String> list = group_anagrams.get(tmp);
                list.add(s);
            }else {
                List<String> list= new ArrayList<>();
                list.add(s);
                group_anagrams.put(tmp,list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry:group_anagrams.entrySet()){
            List<String> list = entry.getValue();

            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Group_Anagrams group_anagrams = new Group_Anagrams();
   // List<List<String>> lists =        group_anagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> lists =        group_anagrams.groupAnagrams(new String[]{"",""});
        System.out.println(Arrays.toString(lists.toArray()));

    }
}
