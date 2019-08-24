package LeetCode;

/**
 * Created by yl on 2019/8/19.
 */
public class RotateBinarySearch {
    /**
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     输出: 4
     * L d H
     L m t d H m<t
     L t d m H m<t
     L d m t H m<t

     L d t m H m>t
     L t m d H m>t
     L m d t H m>t

     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high){

            if(nums[low]<nums[high]){
                return binarySearch(nums,target,low,high);
            }

            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]<target){
                if(nums[mid]>nums[high]){
                    low=mid+1;//??
                }else{
                    if(target>nums[high]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
            }else{
                if(nums[mid]<nums[high]){
                    high=mid-1;
                }else{
                    if(target>nums[high]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
}
