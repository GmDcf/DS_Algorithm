package LeetCode.DP;

public class Push_Dominoes {
    public static String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        boolean right=false, left=false;
        int l=-1, r=-1;
        for(int i=0; i<chars.length; ){
            if(chars[i]=='.'){
                   if(l==r){
                       l=i;
                       r=i+1;
                   }else {
                       r++;
                   }
                i++;
            }else if(chars[i]=='L'){
                if(!right){
                    while (l<r){
                        chars[l]='L';
                        l++;
                    }
                    while (++i<dominoes.length()&&chars[i]=='L'){//plus one more
                    }

                }else {
                    int ll =l, rr=r-1;
                    while (ll<rr){
                        chars[ll]='R';
                        chars[rr]='L';
                        ll++;
                        rr--;
                    }
                    l=r;
                    right=false;
                    i++;
                }
            }else {
                if(!right) {
                    right = true;
                    l = r = i;
                    i++;
                }else {

                    //String s = "R.R.L"; omit some cases, doesn't think about carefully
                    while (l<r){
                        chars[l]='R';
                        l++;
                    }
                    right =false;
                }
            }

        }

        if(right){
            //String s = ".L.R."; in this case ..a from and to change, should care about has from without end in the end
            while (l<r){
                chars[l]='R';
                l++;
            }
        }

        return new String(chars);
    }
    public static void main(String[] args) {
//        String s= ".L.R...LR..L..";
        String s = "R.R.L";
        System.out.println(pushDominoes(s));
    }
}
