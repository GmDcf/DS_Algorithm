package The_Method_Of_Programming.string;

/*
* 单词翻转输入 I am a student. output student. a am I
* */
public class RotatingOfString {
    public static void main(String[] args) {
        String s = "I am a student.";
        System.out.println(reverseTheWord(s));
    }

    public static String reverseTheWord(String s){
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String word : words){
            char[] cs = word.toCharArray();
            for(int i=0,j=cs.length-1; i<j; i++,j--){
                char c = cs[i];
                cs[i] = cs[j];
                cs[j] = c;
            }
            sb.append(new String(cs)+" ");
        }

        s =  sb.reverse().toString();
        s = s.substring(1);
        return s;
    }

}
