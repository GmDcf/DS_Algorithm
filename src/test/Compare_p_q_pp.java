package test;

public class Compare_p_q_pp {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {2,1,3};
        int p=0,q=0;
        int l=0,r=0;
        for(int i=0; i<3; i++){
            System.out.println(a[p]==b[q]);
            p++;q++;
            System.out.println(a[l++]==b[r++]);
        }
    }
}
