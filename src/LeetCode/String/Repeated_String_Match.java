package LeetCode.String;
/*Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").*/
public class Repeated_String_Match {
    public int repeatedStringMatch(String A, String B) {
        char[] ca = A.toCharArray();
        char[] cb = B.toCharArray();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<ca.length; i++){
                int p=i,q=0,circle=1;
                while (q<cb.length&&ca[p] == cb[q]){
                    p++;
                    q++;
                    if(p==ca.length){
                        p=0;
                        if(q<cb.length)
                        circle++;
                    }
                }
                if(q==cb.length){
                    min=min<circle?min:circle;
                }
            }

        return min==Integer.MAX_VALUE?-1:min;
    }

    public static void main(String[] args) {
        Repeated_String_Match repeated_string_match = new Repeated_String_Match();
        System.out.println(repeated_string_match.repeatedStringMatch("abcd","cdabcdab"));
    }
}
