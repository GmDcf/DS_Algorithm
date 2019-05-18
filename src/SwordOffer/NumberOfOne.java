package SwordOffer;

import java.util.Scanner;

public class NumberOfOne{
    public static int numberOfOneCur(int n){
        int count = 0;
        int flag = 1;
        int i = 0;
        while(i++<32){
            /*  . > 括号 > + - 自增 自减 非 > 算术操作 > 移位操作 > 不等式操作 > 等和不等操作 > 位操作 >逻辑操作 > ?: = +=等赋值操作
            * */
            if((flag&n)==flag){   // &的优先级别比==低，=最低
                count++;
            }
            flag<<=1;
        }
        return count;
    }

    public static int numberOfOne(int n){
        int count = 0;
        while (n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println("方法1，"+n+"的二进制有"+numberOfOneCur(n)+"个 1");
            System.out.println("方法2，"+n+"的二进制有"+numberOfOne(n)+"个 1");
        }
    }


}
