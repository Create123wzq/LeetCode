/**
 * Created by apple on 2019/4/23.
 */
public class Solution27 {
    public static void main(String[] args){
        System.out.println(removeElement(new int[]{1,2,3,4,2,7}, 2));
    }
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for(int n: nums){
            if(n!=val){
                nums[i++] = n;
            }
        }
        return i;
    }
}

