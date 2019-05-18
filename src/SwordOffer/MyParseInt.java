package SwordOffer;

import java.util.Scanner;

public class MyParseInt {
    public static int parseInt(String s){
        if(s==null||s.length()==0){
            throw new NumberFormatException("NULL");
        }

        int i = 0, len = s.length();
        boolean negative = false;
        int min = -Integer.MAX_VALUE;
        int result = 0;
        if(len>0){
            char firstChar = s.charAt(0);
            if(firstChar<0||firstChar>9){
                if(len>1) {
                    if (firstChar == '-') {
                        negative = true;
                        min = Integer.MIN_VALUE;
                    } else if (firstChar != '+') {
                        throw new NumberFormatException("Not a number");
                    }
                }else {
                    throw new NumberFormatException("Not a number");
                }
            }
            i++;
        }else {
            throw new NumberFormatException("NULL");
        }

        while (i<len){ //i++ ,这里i++ 和最后面i++的区别在于，这里i++，如果循环内使用的i就变了
            int c = s.charAt(i)-'0';
            if(c>=0&&c<=9){
                result*=10;
                if(result<(min+c)){
                    throw new NumberFormatException("溢出");
                }
                result-=c;
            }else {
                throw new NumberFormatException("Not a number");
            }
            i++;
        }

        return negative?result:-result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
       // System.out.println(parseInt(s));
      //  System.out.println(Integer.parseInt(s));
        System.out.println(Integer.MAX_VALUE);
    }
}
