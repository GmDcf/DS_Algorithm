package SwordOffer;

public class RotatingArrayFindMin_8 {
    public static void main(String[] args) {

    }

    public static int RotatingArrayFindMin(int[] arr){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("invalid input");
        }

        if(arr.length==1){
            return arr[0];
        }

        int p = 0;
        int q = arr.length-1;
        int mid = 0;


        while (arr[p]>=arr[q]){ // 没有旋转
            if(p-q==1){ //跳出循环条件
                mid = q;
                break;
            }
            mid = (p+q)/2;
            if(arr[p]==arr[mid]&&arr[q]==arr[mid]){ //p mid q 一致 顺序查找
                //顺序查找
                return findByOrder(arr,p,q);
            }

            if(arr[p]<=arr[mid]){
                p = mid;
            }else if(arr[q]>=arr[mid]) {
                q = mid;
            }
        }
        return arr[mid];
    }

    private static int findByOrder(int[] arr, int p, int q){
        int min = Integer.MAX_VALUE;
        for(int i=p;i<=q;i++){
            min = min>arr[i]?arr[i]:min;
        }
        return min;
    }
}
