package algorithm;

public class Solution215 {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        k = right -k + 2;
        while(left < right){
            int p = partition(nums, left, right);
            if(p==k-1){
                break;
            }else if(p<k-1){
                left = p+1;
            }else{
                right = p-1;
            }
        }
        return nums[k-1];

    }
    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        while(left<right){
            while(left<right && nums[right]>=pivot) right--;
            nums[left] = nums[right];
            while(left<right && nums[left]<=pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
