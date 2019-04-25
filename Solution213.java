/**
 * Created by apple on 2019/4/12.
 */
public class Solution213 {
    public static void main(String[] args){
        System.out.println(rob(new int[]{2,3,2}));
    }
    public static int rob(int[] nums) {
        int count = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                count += nums[i];
            }
            sum += nums[i];
        }
        count = nums.length%2==0 ? count:count-nums[nums.length-1];
        return Math.max(count, sum - count);
    }
}
