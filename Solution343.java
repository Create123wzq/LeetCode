/**
 * Created by apple on 2019/4/11.
 */
public class Solution343 {
    public static void main(String args[]){
        System.out.println(integerBreak(3));
    }
    public static int integerBreak(int n) {
        int []dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max(Math.max(j*dp[i-j], j*(i-j)),dp[i]);
            }
        }
        return dp[n];
    }
}
