package LeetCode.String;

import java.util.*;

public class Reorder_Log_Files {
    /*You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

    Each word after the identifier will consist only of lowercase letters, or;
    Each word after the identifier will consist only of digits.

We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.*/
    public String[] reorderLogFiles(String[] logs) {
        List<String> digits = new LinkedList<>();
        Map<String, Set<String>> letters = new TreeMap<>();
        for(String log:logs){
            String[] words = log.split(" ");
            String second = words[1];
            if(isNumeric(second)){
                digits.add(log);
            }else {
                String key = log.substring(words[0].length()+1);
                if(letters.containsKey(key)){
                    Set<String> set = letters.get(key);
                    set.add(log);
                }else{
                    Set<String> set = new TreeSet<>();
                    set.add(log);
                    letters.put(key,set);
                }
            }
        }
        String[] sortedlogs = new String[logs.length];
        int p=0;
        for(Map.Entry<String,Set<String>> entry:letters.entrySet()){
            for(String s:entry.getValue()){
                sortedlogs[p++]=s;
            }

        }
        for(String log:digits){
            sortedlogs[p++]=log;
        }
        return sortedlogs;
    }
    public boolean isNumeric(String s){
        char[] cs = s.toCharArray();
        for(char c:cs){
            if(c<'0'||c>'9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] logs=new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] logs1=new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        Reorder_Log_Files reorder_log_files = new Reorder_Log_Files();
        logs = reorder_log_files.reorderLogFiles(logs);
        System.out.println(Arrays.toString(logs));
        System.out.println(Arrays.toString(logs1));
    }
}
