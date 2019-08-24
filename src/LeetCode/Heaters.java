package LeetCode;

import java.util.Arrays;

/**
 * Created by yl on 2019/8/16.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int low = 1, high = houses[houses.length-1]>heaters[heaters.length-1]?houses[houses.length-1]:heaters[heaters.length-1];
        while(low<=high){
            int mid = (high-low)/2+low;
            if(judge(houses,heaters,mid)){
                if(!judge(houses,heaters,mid-1)){
                    return mid;
                }else{
                    high=mid-1;
                }
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean judge(int[] houses, int[] heaters, int len){
        int index = 0;
        for(int heater : heaters){
            int low = heater-len, high = heater+len;
            while(index<houses.length&&houses[index]>=low&&houses[index]<=high){
                index++;
            }
            if(index==houses.length){
                return true;
            }
            if(houses[index]<low){
                return false;
            }

        }
        if(index==houses.length) {
            return true;
        }
        return false;
    }

    public int findRadius2(int[] houses, int[] heaters){
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int radis = 0;
        int inh = 0;
        for(int i=0; i<heaters.length&&inh<houses.length; i++) {
            if(heaters[i]<houses[inh]){
                continue;
            }
            int leftRad=Integer.MAX_VALUE, rightRad=Integer.MAX_VALUE;
            if(i>0){
                leftRad = Math.abs(heaters[i-1]-houses[inh]);
            }
            if(i<heaters.length) {
                rightRad = heaters[i]-houses[inh];
            }
            int heater = 0;
            if(leftRad>rightRad){
                radis = Math.max(radis,rightRad);
                heater = heaters[i];
            }else {
                radis = Math.max(radis,leftRad);
                heater=heaters[i-1];
            }

            if (inh < houses.length){

                while (inh < houses.length && houses[inh] <= heater + radis && houses[inh] >= heater - radis) {
                    inh++;
                }
            }
        }
        return radis;
    }


    public static void main(String[] args) {
        Heaters heaters = new Heaters();
        int[] houses =
                {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heatersPos={823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};

        System.out.println(heaters.findRadius(houses,heatersPos));

        System.out.println(heaters.findRadius2(houses,heatersPos));
    }
}
