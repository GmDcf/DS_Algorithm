package SwordOffer;

import java.util.Scanner;

public class print1ToN {
    public static void print(int n){
        if(n<=0){
            throw new IllegalArgumentException("输入必须大于0");
        }
        byte[] arr = new byte[n];
        structNum(arr, 0);
    }

    public static void structNum(byte[] arr, int p){
        if(p==arr.length){
            helpPrint(arr);
        }
        else {
            for(byte i=0; i<10; i++){
                arr[p]=i;
                structNum(arr, p+1);
            }
        }
    }

    public static void helpPrint(byte[] arr){
        boolean headZero = true;
        StringBuilder sb = new StringBuilder();

        for(byte it : arr){
            if(it!=0){
                sb.append(it);
                if(headZero){
                    headZero = false;
                }
            }else {
                if(!headZero){
                    sb.append(it);
                }
            }
        }

        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            print(n);
        }
    }
}
