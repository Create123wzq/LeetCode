import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 2019/3/16.
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0||i>0 && nums[i]!=nums[i-1]){
                int sum = 0 - nums[i];
                int l = i+1;
                int r = nums.length -1;
                while (l<r){
                    if(nums[l]+nums[r]==sum){
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l<r && nums[l]==nums[l+1]) l++;
                        while (l<r && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(nums[l]+nums[r]>=sum){
                        while (l<r && nums[r]==nums[r-1]) r--;
                        r--;
                    }else{
                        while (l<r && nums[l]==nums[l+1]) l++;
                        l++;
                    }
                }
            }

        }
        return ls;
    }

}
