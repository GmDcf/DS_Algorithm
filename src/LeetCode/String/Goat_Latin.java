package LeetCode.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Goat_Latin {
    /*A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.

    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".

    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.

Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
*/
    Character[] chars = new Character[]{'a','e','i','o','u','A','E','I','O','U'};
    Set<Character> vowels = new HashSet<>(Arrays.asList(chars));

    public String toGoatLatin(String S) {
        String[] srr = S.split(" ");
        StringBuffer res = new StringBuffer();
        StringBuffer as = new StringBuffer();
        for(int i=0; i<srr.length; i++){
            as.append("a");
            StringBuffer sb = new StringBuffer(srr[i]);
            if(vowels.contains(sb.charAt(0))){
                sb.append("ma");
            }else{
                char firstChar = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(firstChar);
                sb.append("ma");
            }
            sb.append(as);
            srr[i] = sb.toString();
            res.append(sb);
            res.append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "I speak Goat Latin";
        System.out.println(new Goat_Latin().toGoatLatin(s));
    }
}
