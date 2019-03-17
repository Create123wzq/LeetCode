import java.util.Arrays;

/**
 * 动态规划
 * 设字符串为str，长度为n，p[i][j]表示第i到第j个字符组成的字符创是回文子串（i<=j），则：
   状态初始条件：dp[i][i]=1 （i=0：n-1）
   状态转移方程：dp[i][j]=dp[i+1][j-1] + 2  if（str[i]==str[j] && j!=i+1）
               dp[i][j]=2  if（str[i]==str[j] && j==i+1）
 */
public class Solution5 {
    public static String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }
        int start = 0;
        int max = 1;
        int n = s.length();
        int[][] res = new int[n][n];
        for(int j=0;j<n;j++){
            res[j][j] = 1;
            for(int i=j-1;i>=0;i--){
                if(s.charAt(i)==s.charAt(j)){
                    if(j==i+1){
                        res[i][j] = 2;
                    }else{
                        if(res[i+1][j-1]>0){
                            res[i][j] = res[i+1][j-1] + 2;
                        }
                    }
                }
                if(res[i][j]>max){
                    max = res[i][j];
                    start = i;
                }
            }
        }
        return s.substring(start, start+max);
    }
    public static void main(String[] args){
        System.out.println(longestPalindrome("sddlkdfalklaf"));
    }
}
