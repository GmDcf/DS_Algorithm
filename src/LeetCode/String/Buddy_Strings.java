package LeetCode.String;
/*Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.*/
public class Buddy_Strings {

public boolean buddyStrings(String A, String B) {
    if(A.length()!=B.length()){
        return false;
    }
    char[] ca = A.toCharArray();
    char[] cb = B.toCharArray();

    int first = 0;
    int[] alphas = new int[26];
    while(first<ca.length&&ca[first]==cb[first]){
        alphas[ca[first]-'a']++;
        first++;
    }
    if(first==ca.length){
        for(int alpha:alphas){
            if(alpha>1){
                return true;
            }
        }
        return false;
    }

    int last = first+1;
    while(last<ca.length&&cb[last]==ca[last]){
        last++;
    }
    if(last==ca.length){
        return false;
    }

    if(ca[first]!=cb[last]||ca[last]!=cb[first]){
        return false;
    }

    int index = last+1;
    while(index<ca.length&&cb[index]==ca[index]){
        index++;
    }
    if(index==ca.length){
        return true;
    }

    return false;
    }

    public static void main(String[] args) {
        Buddy_Strings bs = new Buddy_Strings();
        System.out.println(bs.buddyStrings("ab","ba"));
        System.out.println(bs.buddyStrings("ab","ab"));
        System.out.println(bs.buddyStrings("aaaaaaabc","aaaaaaacb"));
        System.out.println(bs.buddyStrings("aa","aa"));
        System.out.println(bs.buddyStrings("","aa"));
    }
}
