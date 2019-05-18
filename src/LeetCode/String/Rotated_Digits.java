package LeetCode.String;
/*X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
*/
public class Rotated_Digits {
    public int rotatedDigits(int N) {
        int count = 0;
        int[] goods = new int[N+1];
        for(int i=1;i<=N;i++){
            if(isGood(i,goods)==2){
                count++;
            }
        }
        return count;
    }

    public int isGood(int n, int[] goods){
        if(goods[n]!=0){
            return goods[n];
        }
        if(n>=10){
            int lastdigit = n%10;
            int newn = n/10;
            if(lastdigit==3||lastdigit==4||lastdigit==7){
                return goods[n]=-1;
            }else{
                int tmp = isGood(newn,goods);
                if(tmp==2){
                    return goods[n]=2;
                }else if(tmp==-1){
                    return goods[n]=-1;
                }else if(tmp==1){
                    if(lastdigit==0||lastdigit==1||lastdigit==8){
                        return goods[n]=1;
                    }else{
                        return goods[n]=2;
                    }
                }
            }
        }else if(n==3||n==4||n==7){
            return goods[n]=-1;
        }
        else if(n==0||n==1||n==8){
            return goods[n]=1;
        }else{
            return goods[n]=2;
        }
        return goods[n];
    }

    public static void main(String[] args) {
        System.out.println(new Rotated_Digits().rotatedDigits(10));
        //10000->2320
    }
}
