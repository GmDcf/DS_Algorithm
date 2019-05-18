package LeetCode.String;
/*Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.*/
public class String_Compression {
    public int compress(char[] chars) {
        //int len = 0;
        char c = chars[0];
        int count = 1;
        //p is index, we need to return len, figure out the what you need
        int p=0;
        for(int i=1; i<=chars.length; i++){
            if(i==chars.length||chars[i]!=c){//update condition is not only "!=",but also the end of arr
                if(count==1){
                    chars[p++]=c;
                }else{
                    // len+=(count+1);
                    chars[p++]=c;
                    char[] numc = (count+"").toCharArray();
                    for(char nc:numc){
                        chars[p++]=nc;
                    }
                }
                if(i<chars.length){//because the i can achieve length, it's necessary to check it out.
                    //may be we can check i==len-1,to break;
                    c = chars[i];
                    count=1;
                }
            }else{
                count++;
            }
        }
        // after we compress, the len can show in-place the arr of len p
        return p;
    }

    public static void main(String[] args) {
        char[] c1 = new char[]{'a'};
        char[] c2 = new char[]{'a','a','b','b','c','c','c'};
        char[] c3 = new char[]{'a','a','a','a','a','b'};
        System.out.println(new String_Compression().compress(c1));
        System.out.println(new String_Compression().compress(c2));
        System.out.println(new String_Compression().compress(c3));
    }
}
