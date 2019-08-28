package LeetCode.hash;

/**
 * @author yanglong09
 * @date 2019/8/28.
 */
public class NumberOfRabbits781 {
    public int numRabbits(int[] answers) {
        int count = 0 ;
        int[] colors = new int[1000];
        for(int ans : answers){
            if(ans == 0){
                count++;
                continue;
            }
            if(colors[ans]==0){
                count+=(ans+1);
                colors[ans]=ans;
            }else {
                colors[ans]=(colors[ans]-1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfRabbits781 numberOfRabbits781 = new NumberOfRabbits781();
        System.out.println(numberOfRabbits781.numRabbits(new int[]{1,1,2}));
        System.out.println(numberOfRabbits781.numRabbits(new int[]{10,10,10}));
        System.out.println(numberOfRabbits781.numRabbits(new int[]{1,0,1,0,0}));
        System.out.println(numberOfRabbits781.numRabbits(new int[]{0,0,1,1,1}));
    }
}
