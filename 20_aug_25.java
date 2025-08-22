// leetcode.com/problems/count-square-submatrices-with-all-ones/?envType=daily-question&envId=2025-08-20

// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 
 class Solution {
    public int countSquares(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int result=0;
        int[][]indices=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==1){
                    if (i==0 || j==0){
                        indices[i][j]=1;                    
                    }
                    else{
                        indices[i][j]=Math.min(Math.min(indices[i-1][j],indices[i][j-1]),indices[i-1][j-1])+1;
                    }
                }
                result+=indices[i][j];
            }
        }
        return result;
    }
}