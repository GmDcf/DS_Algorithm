package SwordOffer;
import java.util.Scanner;

public class ParseInt {
    public static int parseInt(String s){
        if(s==null){//代码鲁棒性
            throw new NumberFormatException("NULL");
        }

        int result = 0;
        int i=0,  len = s.length(); //遍历下标
        int digit; //每次读的位
        int MIN = -Integer.MAX_VALUE; //越界标准,默认为正，正数最大值为Integer.MAX_VALUE，因为后面使用的减法，所以处理为负
        boolean negative= false; //正负标志

        if(len>0){
            char firstChar = s.charAt(i);
            if(firstChar<'0') { //前面可能有符号，无符号默认为正
                if (firstChar == '-') {
                    negative = true;
                    MIN = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw new NumberFormatException(s);  //有符号，但不为+或者-号，抛出异常
                }
                if(len == 1){//有符号，但无后续数字抛出异常
                    throw new NumberFormatException(s);
                }
                i++;
            }

            while (i<len){
                digit = s.charAt(i)-'0';
                if(digit>=0||digit<=9){
                    result*=10;
                    if(result<MIN+digit){ //（MIN+digit）代表的是当前result不能小于的值，否则result减去digit就会越界。
                                            //而使用 result-digit 不易判断是否越界
                        throw new NumberFormatException(s);
                    }
                    result-=digit;
                }else {
                    throw new NumberFormatException(s); //字符不为数字抛出的异常
                }
                i++;
            }
        }else {
            throw new NumberFormatException(s);
        }

        return  negative?result:-result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(parseInt(s));
        System.out.println(Integer.parseInt(s));
    }
}

