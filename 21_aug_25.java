// leetcode.com/problems/count-submatrices-with-all-ones/?envType=daily-question&envId=2025-08-21

// Given an m x n binary matrix mat, return the number of submatrices that have all ones.

class Solution {
    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(mat[i][j]==1){
                    if(j==0){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j]=dp[i][j-1]+1;
                    }
                    int mw=dp[i][j];
                    for(int k=i;k>=0;k--){
                        mw=Math.min(mw,dp[k][j]);
                        res+=mw;
                    }
                }
            }
        }
        return res;
    }
}