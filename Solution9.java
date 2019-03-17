/**
 * Created by apple on 2019/3/16.
 */
public class Solution9 {
    public static boolean isPalindrome(int x){
        int res = 0;
        int y = x;
        while(y!=0){
            res = res*10 + y%10;
            y /= 10;
        }
        return res == x;
    }
    public static void main(String [] args){
        System.out.println(isPalindrome(40804));
    }
}
