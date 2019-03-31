import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 2019/3/31.
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int n1 = target-nums[i];
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int n2 = n1-nums[j];
                int l = j+1;
                int r = nums.length-1;
                while (l<r){
                    if(nums[l]+nums[r]==n2) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }else if(nums[l]+nums[r]<n2){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return list;
    }
}
