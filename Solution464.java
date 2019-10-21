/**
 * Created by apple on 2019/9/15.
 */
public class Solution464 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            int temp = 0;
            for(int j=i;j<n;j++){
                temp += nums[j];
                dp[j][i] = temp;
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j] = dp[j][i] - Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1]*2>=dp[n-1][0];
    }
}

