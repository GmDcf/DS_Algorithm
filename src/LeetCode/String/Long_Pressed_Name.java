package LeetCode.String;
/*Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
*/
public class Long_Pressed_Name {
    public boolean isLongPressedName(String name, String typed) {
        char[] cn = name.toCharArray();
        char[] ct = typed.toCharArray();

        int p=0,q=0;
        boolean flag = true;
        while(p<name.length()&&q<typed.length()){
            if(cn[p]==ct[q]){
                p++;
                q++;
                flag=true;
            }else{
                flag = false;
                q++;
            }
        }
        /*
        * true when all char in name has corresponding char in types
        * means p==name.length() and flag is true
        * */
        return p==name.length()&&flag;
    }

    public static void main(String[] args) {

        System.out.println(new Long_Pressed_Name().isLongPressedName ("pyplrz","ppyypllr"));
    }
}
