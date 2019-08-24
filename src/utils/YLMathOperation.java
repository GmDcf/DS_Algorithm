package utils;

/**
 * Created by yl on 2019/8/10.
 */
public class YLMathOperation {
    public static float sqrt(int num, int radix){
        if(num<0||radix<0){
            throw new IllegalArgumentException("input num and radix must larger than 0");
        }
        int left = 0, right =num/2, mid=0;

        while(left<=right){
             mid = (right-left)/2+left;
            int tmp = mid*mid;
            if(tmp==num){
                return mid;
                //转浮点数
            }
            if(tmp<num){
                /*
                *(mid+1)^2
                 */
                int tmp_1 = tmp+1+2*mid;
                if(tmp_1<num){
                    left=mid+1;
                }else if(tmp_1==num){
                    return mid+1;
                }else{
                    //找到整数部分
                    break;
                }
            }else{
                int tmp_2 = tmp+1-2*mid;
                if(tmp_2>num){
                    right=mid-1;
                }else if(tmp_2==num){
                    return mid-1;
                }else{
                    mid--;
                    break;
                }
            }

        }

        float res = mid;
        float div = 1;
        int fmid =0 ;
        for(int i=0; i<radix; i++){
            div/=10;
            int low = 0, high = 9;
            while(low<=high){
                fmid = (low+high)/2;
                float tmp_res = res+(fmid*div);
                float float_num = tmp_res*tmp_res;
                if(float_num<num){
                    if((tmp_res+div)*(tmp_res+div)>=num){
                        break;
                    }
                    low = fmid+1;
                }else {
                    high = fmid-1;
                }
            }
            res+=(fmid*div);
        }

        System.out.println("num-res*res="+(num-res*res));

        return res;
    }

    public static void main(String[] args) {
        System.out.printf("%f",sqrt(9,6));
    }


}
