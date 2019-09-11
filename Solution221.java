package algorithm;

class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int maxlen = 0;
        int row = matrix.length;
        int col = row == 0 ? 0 : matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                    maxlen = Math.max(dp[i][j], maxlen);
                }
            }
        }
        return maxlen*maxlen;
    }

    public int maximalSquare2(char[][] matrix) {
        int maxlen = 0;
        int row = matrix.length;
        int col = row == 0 ? 0 : matrix[0].length;
        int[] dp = new int[col+1];
        int pre = 0;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j-1], pre), dp[j]) + 1;
                    maxlen = Math.max(dp[j], maxlen);
                }else{
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return maxlen*maxlen;
    }
}