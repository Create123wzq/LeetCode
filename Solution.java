import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key = target - nums[i];
            if(map.containsKey(key)){
                return new int[] {map.get(key), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int [] {-1, -1};
    }
    public static void main(String [] args){
        int[] nums = {3, 1, 7, 5, 6};
        int target = 13;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}