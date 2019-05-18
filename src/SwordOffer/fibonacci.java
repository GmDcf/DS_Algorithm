package SwordOffer;

import java.util.Scanner;

public class fibonacci {
    public static int fibonacci(int n){
        int result = 0;
        int pre = 1;
        int sen = 0;
        if(n==0){
            return 0;
        }else if(n==1){
            return pre;
        }

        for(int i=2; i<=n; i++){
            result = pre+sen;
            sen = pre;
            pre = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(n+"'s fibonacci="+fibonacci(n));
        }
    }
}
