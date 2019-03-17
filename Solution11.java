/**
 * Created by apple on 2019/3/16.
 */
public class Solution11 {
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int area = 0;
        while(l!=r){
            area = Math.max(area, Math.min(height[l], height[r])*(r-l));
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return  area;
    }

    public static void main(String[] args){
        System.out.println(maxArea(new int[]{3,4,5,4,7}));
    }

}
