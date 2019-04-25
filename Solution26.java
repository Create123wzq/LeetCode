/**
 * Created by apple on 2019/4/23.
 */
public class Solution26 {
    public static void main(String args[]){
        System.out.println(removeDuplicates(new int[]{1,1,2,2,3,4,4}));
    }
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        int i = 0;
        while(j<nums.length){
            if(j==0){
                nums[i++] = nums[j];
            }else{
                while (j<nums.length && nums[j]==nums[j-1]){
                    j++;
                }
                if(j<nums.length){
                    nums[i++] = nums[j];
                }
            }
            j++;

        }
        return i;
    }
    public static int removeDuplicates2(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
