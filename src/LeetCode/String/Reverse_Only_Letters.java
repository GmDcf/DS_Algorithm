package LeetCode.String;

public class Reverse_Only_Letters {
    /*Given a string S, return the "reversed" string
    where all characters that are not a letter stay in the same place,
    and all letters reverse their positions.*/
    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        int n = cs.length;
        int p=0,q=n-1;
        while(p<q){
            if((cs[p]>='a'&&cs[p]<='z')||(cs[p]>='A'&&cs[p]<='Z')){
                if((cs[q]>='a'&&cs[q]<='z')||(cs[q]>='A'&&cs[q]<='Z')){
                    char tmp = cs[q];
                    cs[q]=cs[p];
                    cs[p]=tmp;
                    q--;
                    p++;
                }else{
                    q--;
                }
            }else{
                p++;
            }
        }
        return new String(cs);
    }

}
