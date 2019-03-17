/**
 * Created by apple on 2019/3/16.
 */
public class Solution7 {
    public static int reverse(int x) {
        int tail;
        int result = 0;
        while (x!=0){
            tail = x % 10;
            int newResult = result*10 + tail;
            if((newResult-tail)/10 != result){
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(reverse(342));
    }
}
