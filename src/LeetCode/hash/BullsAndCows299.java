package LeetCode.hash;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yanglong09
 * @date 2019/8/29.
 */
public class BullsAndCows299 {
    public String getHint(String secret, String guess) {
        char[] csecret = secret.toCharArray();
        char[] cguess = guess.toCharArray();
        int[] numa = new int[10];
        int[] numb = new int[10];

        int counta=0, countb=0;

        int i=0;

        for( i=0; i<cguess.length&&i<csecret.length; i++){
            if(cguess[i]==csecret[i]){
                counta++;
            }else{
                numa[cguess[i]-'0']++;
                numb[csecret[i]-'0']++;
            }
        }

        for(int j=i; j<cguess.length;j++){
            numa[cguess[j]-'0']++;
        }

        for(int j=i; j<csecret.length;j++){
            numb[cguess[j]-'0']++;
        }

        for(int j=0; j<10; j++){
            countb+=Math.min(numa[j],numb[j]);
        }

        return counta+"A"+countb+"B";
    }

    public static void main(String[] args) {
        BullsAndCows299 bullsAndCows299 = new BullsAndCows299();
        System.out.println(bullsAndCows299.getHint("1807","7810"));
        System.out.println(bullsAndCows299.getHint("1123","0111"));
        System.out.println(bullsAndCows299.getHint("1122","1222"));

    }
}
