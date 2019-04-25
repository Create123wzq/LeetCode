public class Solution209 {
    public static void main(String[] args){


    }
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int len = nums.length;
        int res = len+1;
        int sum = 0;
        while (left<len){
            if(right+1<len && sum<s){
                right++;
                sum += nums[right];
            }else{
                sum -= nums[left];
                left++;
            }
            if(sum>=s){
                res = Math.min(res, right-left+1);
            }
        }
        return res == len+1 ? 0:res;
    }
}