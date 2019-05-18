package SwordOffer;

import java.util.Scanner;

public class Power {
    public static double power(double base, int exponenet){
            if(base<0){
                throw new IllegalArgumentException("");
            }

            if(equal(base, 0.0)){
                 if(exponenet<=0){
                     throw new IllegalArgumentException("");
                 }
                 else return 0;
            }
            boolean negative = false;
            if(equal(exponenet,0)){
                return 1;
            }
            if(exponenet<0){
                negative = true;
                exponenet = -exponenet;
            }

            double result = powerHelper(base, exponenet);
            return negative?1/result:result;
    }

    public static  double powerHelper(double base, int exponenet){
         if(exponenet==0){
             return 1;
         }
         if(exponenet==1){
             return base;
         }

        double result = powerHelper(base, exponenet>>1);
         result*=result;
         if((exponenet&1)==1){
             return result*base;
         }
         return result;
    }

    private static boolean equal(double a, double b){
        return Math.abs(a-b)<0.00001;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            double base = sc.nextDouble();
            int exponent = sc.nextInt();
            System.out.println(power(base, exponent));
        }
    }
}
