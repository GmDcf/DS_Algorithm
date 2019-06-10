package LeetCode.String;

public class ValidABC {
    public boolean isValid(String S) {
        while (S.length()>0){
            char[] cs = S.toCharArray();
            if(cs[0]!='a'){
                return false;
            }
            int index = S.indexOf("abc");
            if(index==-1) {
                return false;
            }
            S = S.substring(0,index)+S.substring(index+3);
        }
        return true;
    }

    public static void main(String[] args) {
        ValidABC validABC = new ValidABC();
        System.out.println(validABC.isValid("aabcbc"));
        System.out.println(validABC.isValid("abcabcaabcbc"));
        System.out.println(validABC.isValid("abccba"));
        System.out.println(validABC.isValid("cababc"));
        System.out.println(validABC.isValid("bac"));
    }
}
