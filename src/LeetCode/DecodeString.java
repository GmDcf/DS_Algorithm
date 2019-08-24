package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yl on 2019/8/19.
 */
public class DecodeString {
    public String decodeString(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> ck = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int val = 0;
        for(char c : cs){
            if(c==']'){
                ArrayList<Character> ssb = new ArrayList<>();
                char tmpChar;
                while(ck.size()>0&&(tmpChar=ck.pop())!='['){
                    ssb.add(tmpChar);
                }
                while(ck.size()!=0&&ck.peek()>='0'&&ck.peek()<='9'){

                    val*=10;
                    val+=ck.pop()-'0';
                }
                while(val>0){
                    for(int i=ssb.size()-1; i>=0; i--){
                        ck.push(ssb.get(i));
                    }
                    val--;
                }
            }else{
                ck.push(c);
            }
        }

        while(ck.size()>0){
            sb.append(ck.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
    }
}
