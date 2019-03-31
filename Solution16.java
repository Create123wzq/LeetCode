import java.util.Arrays;

/**
 * Created by apple on 2019/3/31.
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<nums.length-2;i++){
            int t = target - nums[i];
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int temp = Math.abs(t-nums[l]-nums[r]);
                if(temp<min){
                    min = temp;
                    res = nums[i]+nums[l]+nums[r];
                }
                if(nums[l]+nums[r]<t){
                    l++;
                }else{
                    r--;
                }
            }

        }
        return res;
    }
}
